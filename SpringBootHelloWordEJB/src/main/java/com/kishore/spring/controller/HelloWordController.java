package com.kishore.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.ejb3.HelloBeanRemote;

@RestController
public class HelloWordController {
	
	@Autowired
	HelloBeanRemote bean;
	
	@GetMapping("/helloword")
	public String getHelloword()
	{
		return bean.getHelloMessage();
	}

}
