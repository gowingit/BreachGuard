package com.gowri.breachguard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gowri.breachguard.service.BreachGuardService;

@RestController
@RequestMapping("/pwdmanager")
public class BreachGuardResource {

	private BreachGuardService bgSvc;

	BreachGuardResource(BreachGuardService bgSvc) {
		this.bgSvc = bgSvc;
	}

	@PostMapping("/verify")
	public ResponseEntity<String> verifyBreach(@RequestParam String password) {

		if (bgSvc.verifyBreach(password)){
			return ResponseEntity.ok("Password has been breached. Please choose a different password.");
		}
		return ResponseEntity.ok("Password is safe to use.");
	}


}
