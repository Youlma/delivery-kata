package com.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.delivery")
public class DeliveryKataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryKataApplication.class, args);
	}

}
