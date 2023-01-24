package com.producto.mservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class ProductoMserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductoMserviceApplication.class, args);
	}

}
