package info.changelogs.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import info.changelogs.app.service.OrganizationServiceApi;

class OrganizationControllerUnitTest {

	@InjectMocks
	private OrganizationController organizationController;

	@Mock
	private OrganizationServiceApi organizationService;

	@Test
	void contextLoads() throws Exception {
		assertThat(organizationController).isNotNull();
	}

	@Test
	void testGetOwnerList() {
		fail("Not yet implemented");
	}

}
