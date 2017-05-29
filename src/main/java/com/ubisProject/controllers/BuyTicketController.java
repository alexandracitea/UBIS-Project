package com.ubisProject.controllers;

import com.ubisProject.DTO.CreatingCustomerDto;
import com.ubisProject.DTO.CustomerDto;
import com.ubisProject.models.Customer;
import com.ubisProject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/** This controller manages the tickets sales. Using the POST method, a customer needs to insert his/her name, phone,
email adress, the name of the event and select a ticket.
 **/

@RestController
@RequestMapping("/buy_ticket")
public class BuyTicketController {

    @Autowired
    private CustomerService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<CustomerDto> buyTicket(@RequestBody CreatingCustomerDto customerDto) {
        Customer customer = toCreatingModel(customerDto);
        Customer custTicket = this.service.save(customer);
        return new ResponseEntity<>(toDto(custTicket), HttpStatus.CREATED);

    }

    private CustomerDto toDto(Customer ticket) {
        CustomerDto dto = new CustomerDto();
        dto.customerId = ticket.getCustomerId();
        dto.name = ticket.getName();
        dto.phone = ticket.getPhone();
        dto.email = ticket.getEmail();
        dto.eventName = ticket.getEventName();
        dto.ticketId = ticket.getTicketId();
        return dto;
    }

    private Customer toCreatingModel(CreatingCustomerDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.name);
        customer.setPhone(dto.phone);
        customer.setEmail(dto.email);
        customer.setEventName(dto.eventName);
        customer.setTicketId(dto.ticketId);

        return customer;
    }
}
