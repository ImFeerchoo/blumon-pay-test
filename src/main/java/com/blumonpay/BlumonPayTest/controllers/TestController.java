package com.blumonpay.BlumonPayTest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/test")
	public String hello() {
		System.out.println("Este es mi controlador");
		return "terminals";
	}
	
	@GetMapping("/")
	public String hello2() {
		System.out.println("Este es mi controlador");
		return "index";
	}
	
}
