package com.trpo.lectureRepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.trpo.lectureRepo"})
public class LectureRepoApplication {
	public static void main(String[] args) throws Exception{
		SpringApplication.run(LectureRepoApplication.class, args);
	}
}