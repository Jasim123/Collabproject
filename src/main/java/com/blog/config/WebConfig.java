package com.blog.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.FilterType;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.blog")
public class WebConfig {
	
}