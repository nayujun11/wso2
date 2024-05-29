package com.builder.migration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.builder.migration.entity.*;

public interface ApiDetailRepository extends JpaRepository<ApiDetail, String>{
}
