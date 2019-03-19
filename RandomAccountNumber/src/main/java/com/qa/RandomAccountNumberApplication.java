package com.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RandomAccountNumberApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(RandomAccountNumberApplication.class, args);
		System.out.println(((Generator) ac.getBean("generator")).listOfUnique6(5));
		System.out.println(((Generator) ac.getBean("generator")).listOfUnique8(5));
		System.out.println(((Generator) ac.getBean("generator")).listOfUnique10(5));
	}

}
