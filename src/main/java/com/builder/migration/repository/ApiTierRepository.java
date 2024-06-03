package com.builder.migration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.builder.migration.entity.ApiTier;

public interface ApiTierRepository extends JpaRepository<ApiTier, Long>{
}