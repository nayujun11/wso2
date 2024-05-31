package com.builder.migration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.builder.migration.entity.ApiDetail;
import com.builder.migration.repository.ApiDetailRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@SpringBootTest
class MigrationApplicationTests {

	@Autowired
	ApiDetailRepository apiDetailRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	void selectDB() {
		ApiDetail apiDetail = apiDetailRepository.findById("3e4fb900-c9bf-4b1a-9b4c-f254167e05e7")
                                             .orElseThrow(() -> new EntityNotFoundException("ApiDetail not found"));
        System.out.println(apiDetail.getDescription());
	}
}
