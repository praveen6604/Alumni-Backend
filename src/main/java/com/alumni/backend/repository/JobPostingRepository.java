package com.alumni.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alumni.backend.model.JobPosting;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Integer> {

}
