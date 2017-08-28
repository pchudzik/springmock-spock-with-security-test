package com.pchudzik.spingmock.security.securitytest;

class MessageDto {
	private final String user;
	private final String message;

	MessageDto(String user, String message) {
		this.user = user;
		this.message = message;
	}

	public String getUser() {
		return user;
	}

	public String getMessage() {
		return message;
	}
}
