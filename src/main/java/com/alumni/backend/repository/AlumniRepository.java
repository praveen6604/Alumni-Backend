package com.alumni.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alumni.backend.model.Alumni;

@Repository
public interface AlumniRepository extends JpaRepository<Alumni, Integer> {

    Alumni findByAlumniEmail(String email);

}
