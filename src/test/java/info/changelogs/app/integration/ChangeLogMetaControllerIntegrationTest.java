package info.changelogs.app.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import info.changelogs.app.ChangeLogIntegrationTest;
import info.changelogs.app.controller.ChangeLogMetaController;

@ChangeLogIntegrationTest
class ChangeLogMetaControllerIntegrationTest {

	@Autowired
	private ChangeLogMetaController changeLogMetaController;

	@Test
	void contextLoads() {
		assertThat(changeLogMetaController).isNotNull();
	}

}
