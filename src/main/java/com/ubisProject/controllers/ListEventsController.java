package com.ubisProject.controllers;

import com.ubisProject.DTO.CreatingEventDto;
import com.ubisProject.DTO.EventDto;
import com.ubisProject.models.Event_e;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ubisProject.services.EventService;

import java.util.ArrayList;
import java.util.List;

/** This controller lists all the events using GET method **/

@RestController
@RequestMapping("/list_events")
public class ListEventsController {
    @Autowired
    private EventService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<EventDto>> get() {
        List<Event_e> events = this.service.getAll();
        if (events.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<EventDto> result = new ArrayList<>();

        for (Event_e event : events) {
            EventDto dto = toDto(event);
            result.add(dto);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /** I implemented also a POST method to check if on the GET method, the information regarding events successfully appear     **/
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<EventDto> addEvent(@RequestBody CreatingEventDto eventDto) {
        Event_e event = toCreatingModel(eventDto);
        Event_e savedEvent = this.service.save(event);
        return new ResponseEntity<>(toDto(savedEvent), HttpStatus.CREATED);

    }
    private EventDto toDto (Event_e event){
        EventDto dto = new EventDto();
        dto.eventId=event.getEventId();
        dto.title=event.getTitle();
        dto.adress=event.getAddress();
        dto.date = event.getDate();
        dto.description=event.getDescription();
        dto.noOfTickets=event.getNoOfTickets();
        return dto;
    }

    private Event_e toCreatingModel(CreatingEventDto dto) {
        Event_e event = new Event_e();
        event.setTitle(dto.title);
        event.setAddress(dto.adress);
        event.setDate(dto.date);
        event.setDescription(dto.description);
        event.setNoOfTickets(dto.noOfTickets);
        return event;
    }


}