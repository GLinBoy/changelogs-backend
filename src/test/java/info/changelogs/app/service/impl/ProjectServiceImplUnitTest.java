package info.changelogs.app.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import info.changelogs.app.repository.ProjectRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ProjectServiceImplUnitTest {

	@InjectMocks
	private ProjectServiceImpl projectService;

	@Mock
	private ProjectRepository projectRepository;

	@Mock
	private ModelMapper modelMapper;

	@BeforeEach
	void setUp() {
		projectService = new ProjectServiceImpl(projectRepository, modelMapper);
	}

	@Test
	void contextLoads() {
		assertThat(projectService).isNotNull();
	}

	@Test
	void testGetAllNecessary() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProjectDetailByTitle() {
		fail("Not yet implemented");
	}

}
