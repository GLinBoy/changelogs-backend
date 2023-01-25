package info.changelogs.app.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import info.changelogs.app.ChangeLogIntegrationTest;
import info.changelogs.app.web.rest.ContactResource;

@ChangeLogIntegrationTest
class ContactResourceIT {
	
	@Autowired
	private ContactResource contactController;

	@Test
	void contextLoads() {
		assertThat(contactController).isNotNull();
	}

}
