package com.leonardo.heaxagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HeaxagonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeaxagonalApplication.class, args);
	}

}
