package com.mv.SpringAsyncExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringAsyncExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAsyncExampleApplication.class, args);
	}

}
