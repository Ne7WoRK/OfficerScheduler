package com.example.officerscheduler;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Configuration
@SpringBootApplication(scanBasePackages={"com.example.controller","com.example.service"})
@EntityScan("com.example.model")
@EnableJpaRepositories("com.example.repositories")
public class OfficersSchedulerApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure (SpringApplicationBuilder app) {
		return app.sources(OfficersSchedulerApplication.class);
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(OfficersSchedulerApplication.class, args);
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(15000000);
	    return multipartResolver;
	}
}
