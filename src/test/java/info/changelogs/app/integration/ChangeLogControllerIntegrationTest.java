package info.changelogs.app.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.core.Every;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import info.changelogs.app.ChangeLogIntegrationTest;
import info.changelogs.app.controller.ChangeLogController;

@ChangeLogIntegrationTest
class ChangeLogControllerIntegrationTest {

	@Autowired
	private ChangeLogController changeLogController;

	@Autowired
	private MockMvc mockMvc;

	@Value("${application.api-path}/changelog")
	private String baseUrl;
	private final Integer projectId = 1002;
	private final String projectTitle = "Sonsing";
	private final String version = "3.2";

	@Test
	void contextLoads() {
		assertThat(changeLogController).isNotNull();
	}

	@Test
	void testGetLatest() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProjectChangeLog() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProjectChangeLogVersion() {
		fail("Not yet implemented");
	}

}
