package com.alumni.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alumni.backend.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
	
}
