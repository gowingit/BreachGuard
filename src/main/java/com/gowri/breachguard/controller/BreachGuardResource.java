package com.gowri.breachguard.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gowri.breachguard.service.BreachGuardService;

@RestController
public class BreachGuardResource {
	
	private BreachGuardService bgSvc;
	
	public String verifyBreach(String uPassword) {
		
		
		return "";
	}

}
