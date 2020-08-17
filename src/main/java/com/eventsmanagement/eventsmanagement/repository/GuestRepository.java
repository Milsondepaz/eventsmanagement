package com.eventsmanagement.eventsmanagement.repository;

import com.eventsmanagement.eventsmanagement.model.Event;
import com.eventsmanagement.eventsmanagement.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
    Iterable <Guest> findByEvent(Event event);
    Guest findByIdNumber(String idNumber);
}
