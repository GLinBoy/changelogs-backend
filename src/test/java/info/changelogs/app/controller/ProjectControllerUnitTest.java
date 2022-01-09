package info.changelogs.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import info.changelogs.app.service.ProjectServiceApi;

@ExtendWith(MockitoExtension.class)
class ProjectControllerUnitTest {
	
	@InjectMocks
	private ProjectController projectController;
	
	@Mock
	private ProjectServiceApi projectService;

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
