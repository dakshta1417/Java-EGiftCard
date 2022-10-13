package com.egiftcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * @SpringBootApplication is a combination of three annotations :
 * 
 * @SpringBootApplication = @EnableAutoConfiguration + @ComponentScan
 * + @Configuration
 * 
 * @EnableAutoConfiguration - enables auto-configuration and auto-configures the
 * beans that are present in the classpath
 * 
 * @ComponentScan - enables component-scanning
 * 
 * @Configuration - enable Java-based configuration
 */
public class EGiftCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(EGiftCardApplication.class, args); // SpringApplication.run static method is used to start
																	// our application.
	}

}
