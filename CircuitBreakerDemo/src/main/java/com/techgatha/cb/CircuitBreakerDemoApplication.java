package com.techgatha.cb;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableDiscoveryClient
public class CircuitBreakerDemoApplication {
	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(CircuitBreakerDemoApplication.class, args);
		MyService myService = context.getBean(MyService.class);
		System.out.println("Making 40 consecutive Requests");
		int n = 50;
		for (int i = 0; i < n; i++) {
			System.out.println("******* "+i +" **************");
			myService.doSomething(i < (n * 0.6) ? 0 : 2);// 10/0
			TimeUnit.MILLISECONDS.sleep(100);
		}
		
		TimeUnit.SECONDS.sleep(6);

		System.out.println("-- final call --");
		myService.doSomething(2);
	}

}
