package com.blumonpay.BlumonPayTest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NavigationRules {

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logut", required = false) String logout, Model model) {
		
		
		model.addAttribute("alert", false);
		
		if(error != null) {
			model.addAttribute("error", true);
			model.addAttribute("message", "Credenciales incorrectas");
		}
		if(logout != null) {
			model.addAttribute("logout", true);
			model.addAttribute("message", "Has salido exitosamente");
		}
		
		return "/login";
	}
	
}
