package com.nrifintech.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author	Debopam
 * @email	debpal07@gmail.com
 * @created	Nov 9, 2021
 */
@SpringBootApplication
@PropertySources({
	@PropertySource("classpath:customSQL.properties"),
	@PropertySource("classpath:buisnessLogic.properties")
})
@EnableAsync
public class BmsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BmsApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BmsApplication.class);
	}

}
