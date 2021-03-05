package com.qa.fundamental.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile({"test","dev"})
public class AppConfig {
	
}
