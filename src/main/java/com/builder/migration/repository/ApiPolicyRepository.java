package com.builder.migration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.builder.migration.entity.Policy;

public interface ApiPolicyRepository extends JpaRepository<Policy, Long>{
}