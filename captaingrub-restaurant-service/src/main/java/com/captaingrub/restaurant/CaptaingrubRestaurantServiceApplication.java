package com.captaingrub.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * The Class CaptaingrubRestaurantServiceApplication is the main class for the web service.
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
