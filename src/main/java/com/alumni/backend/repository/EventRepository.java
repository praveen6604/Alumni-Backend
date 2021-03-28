package com.alumni.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alumni.backend.model.Event;

public interface EventRepository extends JpaRepository<Event,Integer> {

}
