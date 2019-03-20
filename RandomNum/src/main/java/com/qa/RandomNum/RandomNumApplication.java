    
package com.qa.RandomNum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class RandomNumApplication {

	public static void main(String[] args) {
		SpringApplication.run(RandomNumApplication.class, args);
	}

}