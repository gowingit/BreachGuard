package com.gowri.breachguard.service;

import com.gowri.breachguard.util.Sha1Util;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class BreachGuardService {

	private final RestClient restClient;

	public BreachGuardService(RestClient restClient) {
		this.restClient = restClient;
	}

	public boolean verifyBreach(String uPassword) {

		String hashPwd = Sha1Util.sha1(uPassword).toUpperCase();
		String pwdPrefix = hashPwd.substring(0, 5);
		String pwdSuffix = hashPwd.substring(5);
		String apiResponse = restClient.get()
				.uri("/range/{hashPrefix}", pwdPrefix)
				.retrieve()
				.body(String.class);

		if(apiResponse == null) return false;
		return apiResponse.contains(pwdSuffix);
	}

}








