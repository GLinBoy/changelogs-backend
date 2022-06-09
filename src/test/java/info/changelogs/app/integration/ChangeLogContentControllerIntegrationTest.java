package info.changelogs.app.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import info.changelogs.app.ChangeLogIntegrationTest;
import info.changelogs.app.web.rest.ChangeLogContentResource;

@ChangeLogIntegrationTest
class ChangeLogContentControllerIntegrationTest {

	@Autowired
	private ChangeLogContentResource changeLogContentController;

	@Test
	void contextLoads() {
		assertThat(changeLogContentController).isNotNull();
	}

}
