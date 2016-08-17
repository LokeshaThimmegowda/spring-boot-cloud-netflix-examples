package com.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("discovery-client")
public interface DiscoveryFeignClient {
	
	@RequestMapping(value = "/", method = RequestMethod.GET) 
	String fetchWord();
}
