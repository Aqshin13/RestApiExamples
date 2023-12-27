package com.company.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
	}
        
        
        @Autowired
        Act a;
        
        
        @Bean
        CommandLineRunner clr(){
            return new CommandLineRunner() {
                @Override
                public void run(String... args) throws Exception {
                a.foo("Agshin");
                }
            };
        }

}
