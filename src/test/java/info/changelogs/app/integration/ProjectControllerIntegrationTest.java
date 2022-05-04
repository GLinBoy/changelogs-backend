package info.changelogs.app.integration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import info.changelogs.app.ChangeLogIntegrationTest;
import info.changelogs.app.controller.ProjectController;

@ChangeLogIntegrationTest
class ProjectControllerIntegrationTest {

	@Autowired
	private ProjectController projectController;

	@Test
	void contextLoads() {
		assertThat(projectController).isNotNull();
	}

	@Test
	void testGetUserProjectList() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProjectDetailByTitle() {
		fail("Not yet implemented");
	}

}
