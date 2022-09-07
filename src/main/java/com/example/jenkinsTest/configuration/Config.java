package com.example.jenkinsTest.configuration;


import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.google.common.base.Predicates;
import com.rapipay.config.ConfigWAD;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Configuration
public class Config {
	private static Logger log = LogManager.getLogger(Config.class);
	@Bean
	 public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
	                .apis(Predicates.not(RequestHandlerSelectors.basePackage(" com.rapipay.rebuildCache")))
	                .build();
	 }
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("REBUILD CACHE API")
				.description("RebuildCache Project")	
				.version("1.0").build();
	}
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		try {
			ConfigWAD.makeDatabaseConnection(dataSource);
			
		} catch (Exception e) {
			log.error("Exception while connectong to DB {}", e.getMessage());
		}
		return dataSource;
	}
}
