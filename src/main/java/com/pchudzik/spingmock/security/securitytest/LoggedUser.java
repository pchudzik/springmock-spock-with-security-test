package com.pchudzik.spingmock.security.securitytest;

import java.util.Set;

class LoggedUser {
	private final String name;
	private final Set<String> roles;

	LoggedUser(String name, Set<String> roles) {
		this.name = name;
		this.roles = roles;
	}

	public String getName() {
		return name;
	}

	public boolean canSayHello() {
		return roles.contains("ROLE_USER");
	}
}
