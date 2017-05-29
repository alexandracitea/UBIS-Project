package com.ubisProject.controllers;

import com.ubisProject.DTO.CreatingTicketDto;
import com.ubisProject.DTO.TicketDto;
import com.ubisProject.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ubisProject.services.TicketService;

import java.util.ArrayList;
import java.util.List;

/** This controller displays the details about a ticket using GET method  **/

@RestController
@RequestMapping("/ticket_details")
public class TicketController {
    @Autowired
    private TicketService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TicketDto>> get() {
        List<Ticket> tickets = this.service.getAll();
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<TicketDto> result = new ArrayList<>();

        for (Ticket ticket : tickets) {
            TicketDto dto = toDto(ticket);
            result.add(dto);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /** I implemented also a POST method to check if on the GET method, the information regarding tickets successfully appear     **/

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TicketDto> addTicket(@RequestBody CreatingTicketDto ticketDto) {
        Ticket ticket = toCreatingModel(ticketDto);
        Ticket savedTicket = this.service.save(ticket);
        return new ResponseEntity<>(toDto(savedTicket), HttpStatus.CREATED);

    }

    private TicketDto toDto(Ticket ticket) {
        TicketDto dto = new TicketDto();
        dto.ticketId = ticket.getTicketId();
        dto.nameOfTheEvent = ticket.getNameOfTheEvent();
        dto.seatNo = ticket.getSeatNo();
        dto.price = ticket.getPrice();
        dto.type = ticket.getType();
        return dto;
    }

    private Ticket toCreatingModel(CreatingTicketDto dto) {
        Ticket ticket = new Ticket();
        ticket.setNameOfTheEvent(dto.nameOfTheEvent);
        ticket.setSeatNo(dto.seatNo);
        ticket.setPrice(dto.price);
        ticket.setType(dto.type);
        return ticket;
    }


}