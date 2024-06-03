package com.builder.migration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.builder.migration.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, String>{
}