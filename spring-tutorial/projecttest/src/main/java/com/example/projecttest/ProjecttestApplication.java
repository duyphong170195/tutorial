package com.example.projecttest;

import com.example.projecttest.model.Subscriber;
import com.example.projecttest.repo.SubscriberRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.util.Collection;
import java.util.Collections;

@SpringBootApplication
@ImportResource("classpath*:beans.xml")
public class ProjecttestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjecttestApplication.class, args);
	}


//	@Bean
//	CommandLineRunner runner(SubscriberRepo subscriberRepo) {
//		return args ->  {
//			subscriberRepo.save(new Subscriber("scode1", "a", "b", "c"));
//		};
//	}
}
