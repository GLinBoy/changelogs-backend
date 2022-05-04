package info.changelogs.app.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import info.changelogs.app.ChangeLogIntegrationTest;
import info.changelogs.app.controller.OrganizationMetaController;

@ChangeLogIntegrationTest
class OrganizationMetaControllerIntegrationTest {

	@Autowired
	private OrganizationMetaController organizationMetaController;

	@Test
	void contextLoads() {
		assertThat(organizationMetaController).isNotNull();
	}

}
