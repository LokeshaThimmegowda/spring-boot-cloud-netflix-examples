package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FetchWordController {
	
	@Value("${instance-name}")
	private String instanceName;
	
	@Value("${value-from-config-server}")
	private String valueFromConfigServer;
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String fetchWord() {
		return new StringBuilder(valueFromConfigServer).append(" : ").append(instanceName).toString();
	}
}
