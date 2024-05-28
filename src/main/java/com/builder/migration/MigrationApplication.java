package com.builder.migration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.builder.migration.service.Wso2ApiService;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.builder.migration.repository")
@EntityScan(basePackages = "com.builder.migration.entity") // 엔티티 패키지 지정
public class MigrationApplication implements CommandLineRunner {

	@Autowired
	// private ApiRepository apiRepository;

    private Wso2ApiService wso2ApiService;

	public static void main(String[] args) {
		SpringApplication.run(MigrationApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        // 데이터 삽입
        // Api api1 = new Api();
        // api1.setName("apiManager2");
        // api1.setDescription("api test.");
        // wso2ApiRepository.save(api1);

        // Wso2Api api2 = new Wso2Api();
        // api2.setName("Sample API 2");
        // api2.setDescription("This is the second sample API.");
        // wso2ApiRepository.save(api2);

        if (args.length > 0) {
            // String input = args[0];
            wso2ApiService.wso2SaveApi();
        } else {
            System.out.println("No arguments provided!");
        }
    }

}
