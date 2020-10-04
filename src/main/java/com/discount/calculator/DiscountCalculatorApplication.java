package com.discount.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
@ComponentScan(basePackages = "com.discount")
public class DiscountCalculatorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DiscountCalculatorApplication.class, args);
	}

}
