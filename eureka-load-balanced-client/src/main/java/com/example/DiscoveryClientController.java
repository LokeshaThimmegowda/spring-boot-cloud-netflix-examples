package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.DiscoveryService;

@RestController
public class DiscoveryClientController {
	
	//@Autowired
	//private DiscoveryClient discoveryClient;
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private DiscoveryService discoveryService;
	
	@RequestMapping("/getData")
	public String getData() {
		ServiceInstance serviceInstances = loadBalancerClient.choose("discovery-client");
		return discoveryService.getData(serviceInstances.getUri());
		
	}

}
