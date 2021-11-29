package com.neosoft.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
@EnableCaching //enables spring caches functionality
public class SpringBootStsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStsApplication.class, args);
	}
	
	

}

