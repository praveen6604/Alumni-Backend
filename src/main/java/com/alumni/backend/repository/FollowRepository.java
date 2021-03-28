package com.alumni.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alumni.backend.model.Follow;

public interface FollowRepository extends JpaRepository<Follow, Integer> {

}
