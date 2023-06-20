package com.example.relic;
import com.example.relic.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@EnableAutoConfiguration
@SpringBootApplication
public class RelicApplication {
	public static void main(String[] args) {
		SpringApplication.run(RelicApplication.class, args);
	}

}
