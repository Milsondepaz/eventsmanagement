package com.eventsmanagement.eventsmanagement.repository;

import com.eventsmanagement.eventsmanagement.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    Event findById(long id);
}
