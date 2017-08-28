package com.pchudzik.spingmock.security.securitytest

import com.pchudzik.springmock.infrastructure.annotation.AutowiredMock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.hamcrest.Matchers.equalTo
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ContextConfiguration
@WithMockUser
@WebMvcTest
class SecuredControllerTest extends Specification {
	@Autowired
	MockMvc mockMvc

	@AutowiredMock
	MessageFactory messageFactory

	def "should return message"() throws Exception {
		given:
		messageFactory.createMessage("hello") >> new MessageDto("mocked user", "mock")

		when:
		final request = mockMvc.perform(get("/secured")
				.param("msg", "hello"))

		then:
		request
				.andExpect(status().isOk())
				.andExpect(jsonPath('$.message', equalTo("mock")))
				.andExpect(jsonPath('$.user', equalTo("mocked user")))
	}

}