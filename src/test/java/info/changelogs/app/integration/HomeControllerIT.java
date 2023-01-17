package info.changelogs.app.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.servlet.MockMvc;

import info.changelogs.app.ChangeLogIntegrationTest;
import info.changelogs.app.web.rest.HomeController;

@ChangeLogIntegrationTest
class HomeControllerIT {

	@Autowired
	private HomeController homeController;

	@Autowired
	private MockMvc mockMvc;

	@Value("/swagger-ui.html")
	private String redirectUrl;
	private final String baseUrl = "/";

	@Test
	void contextLoads() {
		assertThat(homeController).isNotNull();
	}

	@Test
	void testRedirect() throws Exception {
		this.mockMvc.perform(get(baseUrl))
		.andDo(print())
		.andExpect(status().isFound())
		.andExpect(redirectedUrl(redirectUrl));
	}

}
