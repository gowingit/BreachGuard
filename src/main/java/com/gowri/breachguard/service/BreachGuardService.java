package com.gowri.breachguard.service;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BreachGuardService {

	private final RestClient restClient;

	public BreachGuardService(RestClient restClient) {
		this.restClient = restClient;
	}

	public String verifyBreach(String uPassword) {

		restClient.get()
				.uri("/range/{hashPrefix}", sha1Prefix(uPassword))
				.retrieve()
				.body(String.class);
		return "";
	}

	private String sha1Prefix(String uPassword) {
		return "TODO";
	}
}
