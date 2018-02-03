package com.captaingrub.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The Class CaptaingrubRestaurantServiceApplication.
 */
@SpringBootApplication
@EnableTransactionManagement
public class CaptaingrubRestaurantServiceApplication {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CaptaingrubRestaurantServiceApplication.class, args);
	}
}
