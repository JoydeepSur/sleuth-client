package com.example.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("sleuth/hello")
@Log4j2
public class HelloController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/client")
	public String hello() {
		log.info("before calling the server");
		restTemplate.getForObject("http://localhost:8081/sleuth/hello/server", String.class);
		log.info("after calling the server");
		return null;
	}
}
