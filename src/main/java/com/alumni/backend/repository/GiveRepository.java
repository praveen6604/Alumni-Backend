package com.alumni.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alumni.backend.model.Give;

public interface GiveRepository extends JpaRepository<Give, Integer> {

}
