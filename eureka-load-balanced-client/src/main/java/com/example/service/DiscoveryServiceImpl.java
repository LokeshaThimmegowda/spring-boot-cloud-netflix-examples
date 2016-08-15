package com.example.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DiscoveryServiceImpl implements DiscoveryService {
	
	@Bean
	RestTemplate restTemplate(){
	    return new RestTemplate();
	}
	
	@Autowired
	RestTemplate restTemplate;

	
	@Override
	@HystrixCommand(fallbackMethod="fallBackMethod")
	public String getData(URI url) {
		return restTemplate.getForObject(url, String.class);
	}
	
	public String fallBackMethod(URI url) {
		return "Hello World fallBackMethod";
	}

}
