package com.ubisProject.repositories;

import com.ubisProject.models.Event_e;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event_e, Long> {
}
