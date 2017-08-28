package com.pchudzik.spingmock.security.securitytest.security;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@PreAuthorize(CanSayHello.CAN_SAY_HELLO)
public @interface CanSayHello {
	String CAN_SAY_HELLO = "@loggedUser.canSayHello()";
}
