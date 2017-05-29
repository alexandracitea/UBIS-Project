package com.ubisProject.controllers;

import com.ubisProject.DTO.CreatingCustomerDto;
import com.ubisProject.DTO.CustomerDto;
import com.ubisProject.models.Customer;
import com.ubisProject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/** This controller helps a customer to cancel his/her request of buying a ticket. **/

@RestController
@RequestMapping("/cancel_ticket")
public class CancelTicketController {

    @Autowired
    private CustomerService service;

    @RequestMapping(method = RequestMethod.POST)
    public void cancelTicket (@RequestBody CreatingCustomerDto customerDto) {
        Customer customer = toCreatingModel(customerDto);
        this.service.delete(customer.getCustomerId());
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
