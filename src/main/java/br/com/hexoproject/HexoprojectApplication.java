package br.com.hexoproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HexoprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HexoprojectApplication.class, args);
	}

}
