package com.example.relic2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.example.relic2"})
public class Relic2Application {
	public static void main(String[] args) {
		SpringApplication.run(Relic2Application.class, args);
	}

}
