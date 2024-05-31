package com.builder.migration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.builder.migration.entity.ApiSwagger;

public interface ApiSwaggerRepository extends JpaRepository<ApiSwagger, Long>{
}