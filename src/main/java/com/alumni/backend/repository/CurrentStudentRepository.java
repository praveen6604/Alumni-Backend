package com.alumni.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alumni.backend.model.CurrentStudent;

public interface CurrentStudentRepository extends JpaRepository<CurrentStudent,String> {
	CurrentStudent findByStudentEmail(String email);
}
