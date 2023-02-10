package info.changelogs.app.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import info.changelogs.app.ChangeLogIntegrationTest;
import info.changelogs.app.web.rest.OrganizationResource;

@ChangeLogIntegrationTest
class OrganizationResourceIT {

	@Autowired
	private OrganizationResource organizationController;

	@Autowired
	private MockMvc mockMvc;

	@Value("${application.api-path}/organizations")
	private String baseUrl;

	@Test
	void contextLoads() {
		assertThat(organizationController).isNotNull();
	}

	@Test
	void testGetOwnerList() throws Exception {
		this.mockMvc.perform(get(baseUrl + "/owner"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.*", hasSize(3)))
		.andExpect(jsonPath("$.*.id", everyItem(Matchers.notNullValue())));
	}

}
