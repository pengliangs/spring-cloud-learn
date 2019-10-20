package com.github.pengliangs.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
public class AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

}
