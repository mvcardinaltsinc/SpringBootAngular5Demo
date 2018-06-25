package com.lko.lms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.lko.lms.rest.jpa")
public class SpringLms extends SpringBootServletInitializer {
	
	private static final Class<SpringLms> SpringLmsClass = SpringLms.class;
    private static final Logger log = LoggerFactory.getLogger(SpringLmsClass);

	public static void main(String[] args) {
		SpringApplication.run(SpringLmsClass, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringLmsClass);
    }

}
