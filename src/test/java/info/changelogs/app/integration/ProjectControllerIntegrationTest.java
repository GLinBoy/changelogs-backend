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
import info.changelogs.app.controller.ProjectController;

@ChangeLogIntegrationTest
class ProjectControllerIntegrationTest {

	@Autowired
	private ProjectController projectController;

	@Autowired
	private MockMvc mockMvc;

	@Value("${application.api-path}/project")
	private String baseUrl;
	private final String TITLE = "Flexidy";

	@Test
	void contextLoads() {
		assertThat(projectController).isNotNull();
	}

	@Test
	void testGetUserProjectList() throws Exception {
		this.mockMvc.perform(get(baseUrl + "/minimized"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.*", hasSize(5)))
		.andExpect(jsonPath("$.*.id", everyItem(Matchers.notNullValue())));
	}

	@Test
	void testGetProjectDetailByTitle() throws Exception {
		this.mockMvc.perform(get(baseUrl + "/title/{title}", TITLE))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.title").value(TITLE))
		.andExpect(jsonPath("$.id").value(1001));
	}

}
