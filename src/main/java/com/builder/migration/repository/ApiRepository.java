package com.builder.migration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.builder.migration.entity.Api;

public interface ApiRepository extends JpaRepository<Api, String>{
}