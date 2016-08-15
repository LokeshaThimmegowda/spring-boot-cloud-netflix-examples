package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FetchWordController {
	
	private String word = "Hello World test";
	
	@RequestMapping("/")
	public String fetchWord() {
		return word;
	}
}
