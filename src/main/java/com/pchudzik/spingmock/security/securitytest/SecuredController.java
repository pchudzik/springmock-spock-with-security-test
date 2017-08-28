package com.pchudzik.spingmock.security.securitytest;

import com.pchudzik.spingmock.security.securitytest.security.CanSayHello;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secured")
class SecuredController {
	private final MessageFactory messageFactory;

	SecuredController(MessageFactory messageFactory) {
		this.messageFactory = messageFactory;
	}

	@RequestMapping
	@PreAuthorize("@loggedUser.canSayHello()")
	public MessageDto hello(@RequestParam String msg) {
		return messageFactory.createMessage(msg);
	}
}
