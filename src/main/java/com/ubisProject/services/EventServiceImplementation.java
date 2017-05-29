package com.ubisProject.services;

import com.ubisProject.models.Event_e;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ubisProject.repositories.EventRepository;

import java.util.List;

@Service
public class EventServiceImplementation implements EventService {
    @Autowired
    private EventRepository repository;

    @Override
    public Event_e save(Event_e entity) {
        return this.repository.save(entity);
    }

    @Override
    public List<Event_e> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Event_e getById(Long eventId) {
        return this.repository.findOne(eventId);
    }

    @Override
    public void delete(Long eventId) {
        this.repository.delete(eventId);
    }
}
