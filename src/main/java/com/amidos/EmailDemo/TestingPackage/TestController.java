package com.amidos.EmailDemo.TestingPackage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
public class TestController {
	
	//These are endpoints
	@GetMapping //If our address bar ends with "www.website.com" and then "/" then that's the default page. Here is where we say hello world
	public String index() {
		return "Hello World!";
	}
	
	@GetMapping("/{id}")
	public String get(@PathVariable("id") long id) {
		return "The id is: " + id;
	}
}
