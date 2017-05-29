package com.ubisProject.services;

import com.ubisProject.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ubisProject.repositories.TicketRepository;

import java.util.List;

@Service
public class TicketServiceImplementation implements TicketService {
    @Autowired
    private TicketRepository repository;

    @Override
    public Ticket save(Ticket entity) {
        return this.repository.save(entity);
    }

    @Override
    public List<Ticket> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Ticket getById(Long ticketId) {
        return this.repository.findOne(ticketId);
    }

    @Override
    public void delete(Long ticketId) {
        this.repository.delete(ticketId);
    }
}
