package com.example.relic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = {"com.example.relic"})
public class RelicApplication {
	public static void main(String[] args) {
		SpringApplication.run(RelicApplication.class, args);
	}

}
