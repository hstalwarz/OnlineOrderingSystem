package com.captaingrub.restaurant.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfig encapsulates the configuration for the Springfox libraries for automating 
 * REST API specification generation.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {     
	
    /**
     * Initializes {@link Docket}, Springfox's primary configuration mechanism.
     *
     * @return the docket
     */
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }
}