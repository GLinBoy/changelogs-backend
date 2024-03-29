package info.changelogs.app.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import info.changelogs.app.ChangeLogIntegrationTest;
import info.changelogs.app.web.rest.ProjectMetaResource;

@ChangeLogIntegrationTest
class ProjectMetaResourceIT {

	@Autowired
	private ProjectMetaResource projectMetaController;

	@Test
	void contextLoads() {
		assertThat(projectMetaController).isNotNull();
	}

}
