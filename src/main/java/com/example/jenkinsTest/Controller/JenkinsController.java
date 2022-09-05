package com.example.jenkinsTest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class JenkinsController {
	
	Logger log = LogManager.getLogger(JenkinsController.class);
	
	@GetMapping(value="/jenkinsApi",headers = "Accept=application/json")
	public String application() {
		return  "JenkinsProject";
	}
}
