package info.changelogs.app.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import info.changelogs.app.ChangeLogIntegrationTest;
import info.changelogs.app.controller.ProjectMetaController;

@ChangeLogIntegrationTest
class ProjectMetaControllerIntegrationTest {

	@Autowired
	private ProjectMetaController projectMetaController;

	@Test
	void contextLoads() {
		assertThat(projectMetaController).isNotNull();
	}

}
