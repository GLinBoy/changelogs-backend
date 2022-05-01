package info.changelogs.app.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import info.changelogs.app.ChangeLogIntegrationTest;
import info.changelogs.app.controller.ChangeLogContentController;

@ChangeLogIntegrationTest
class ChangeLogContentControllerIntegrationTest {

	@Autowired
	private ChangeLogContentController changeLogContentController;

	@Test
	void testChangeLogContentController() {
		fail("Not yet implemented");
	}

}
