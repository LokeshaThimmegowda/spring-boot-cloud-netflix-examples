package com.example.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DiscoveryServiceImpl implements DiscoveryService {
	
	/*@Bean
	RestTemplate restTemplate(){
	    return new RestTemplate();
	}
	
	@Autowired
	RestTemplate restTemplate;*/
	
	@Autowired
	DiscoveryFeignClient discoveryFeignClient;

	
	@Override
	@HystrixCommand(fallbackMethod="fallBackMethod")	
	public String getData(URI url) {
		//return restTemplate.getForObject(url, String.class);
		return discoveryFeignClient.fetchWord();
	}
	
	public String fallBackMethod(URI url) {
		return "Hello World fallBackMethod";
	}

}
