package com.pchudzik.spingmock.security.securitytest;

import org.springframework.stereotype.Service;

@Service
class MessageFactory {
	private final LoggedUser loggedUser;

	MessageFactory(LoggedUser loggedUser) {
		this.loggedUser = loggedUser;
	}

	public MessageDto createMessage(String msg) {
		return new MessageDto(loggedUser.getName(), msg);
	}
}
