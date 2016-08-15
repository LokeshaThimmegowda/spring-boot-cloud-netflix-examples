package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumeConfigController {
	
	@Value("${data}")
	private String data;
	
	@RequestMapping("/fetchConfigData")
	public String getConfigData() {
		return data;
	}

}
