package com.demo.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityDemoApplication.class, args);
	}
	
	@Configuration 
	public class WebConfig implements WebMvcConfigurer {

		@Override 
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/resources/**")
			.addResourceLocations("classpath:/resources/","classpath:/static/images/","classpath:/static/");

		} 
	}

}
