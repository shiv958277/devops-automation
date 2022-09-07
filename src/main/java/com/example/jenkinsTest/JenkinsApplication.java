package com.example.jenkinsTest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.rapipay.config.ConfigWAD;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class JenkinsApplication {
	private static final Logger log = LogManager.getLogger(JenkinsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JenkinsApplication.class, args);
	}
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	EntityManager entityManager;
	@PostConstruct
	private void init() {
		ConfigWAD.initStoredProcedure(entityManager);
		ConfigWAD.initStoredProcedureNew(jdbcTemplate);
		ConfigWAD.initReadRedisData();
		log.info("***********  INIT METHOD ************");
	}
	@PreDestroy
	private void shutdown() {
		log.info("*********** DESTROY SUCCESS ***************");
	}
}
