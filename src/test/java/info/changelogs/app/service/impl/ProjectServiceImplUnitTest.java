package info.changelogs.app.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doReturn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import info.changelogs.app.dto.projection.ProjectMinimizedDTO;
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

	private final String DEFAULT_USERNAME = "admin";

	private final Pageable pageable = PageRequest.of(0, 1_000);

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
		doReturn(new PageImpl<ProjectMinimizedDTO>(generateProjectMinimizedDTO(3)))
			.when(projectRepository).findAllNecessary(DEFAULT_USERNAME, pageable);
	
		Page<ProjectMinimizedDTO> page = projectService.getAllNecessary(DEFAULT_USERNAME, pageable);
		assertThat(page.getTotalElements()).isEqualTo(3);
	}
	
	private List<ProjectMinimizedDTO> generateProjectMinimizedDTO(Integer counter) {
		return IntStream.range(0, counter).mapToObj(i -> {
			ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
			ProjectMinimizedDTO projection = factory.createProjection(ProjectMinimizedDTO.class);
			projection.setId(Long.valueOf(i));
			projection.setName(String.format("name %d", i));
			projection.setTitle(String.format("title %d", i));
			projection.setOwner(String.format("owner %d", i));
			return projection;
		}).collect(Collectors.toList());
	}

	@Test
	void testGetProjectDetailByTitle() {
		fail("Not yet implemented");
	}

}
