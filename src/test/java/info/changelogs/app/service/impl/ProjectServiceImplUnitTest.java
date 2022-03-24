package info.changelogs.app.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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

import info.changelogs.app.dto.ProjectDetailedDTO;
import info.changelogs.app.dto.projection.ProjectMinimizedDTO;
import info.changelogs.app.entity.Organization;
import info.changelogs.app.entity.Project;
import info.changelogs.app.repository.ProjectRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ProjectServiceImplUnitTest {

	@InjectMocks
	private ProjectServiceImpl projectService;

	@Mock
	private ProjectRepository projectRepository;

	private final String DEFAULT_USERNAME = "admin";
	private final String DEFAULT_TITLE = "title";

	private final Pageable pageable = PageRequest.of(0, 1_000);

	@BeforeEach
	void setUp() {
		projectService = new ProjectServiceImpl(projectRepository, new ModelMapper());
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
		doReturn(Optional.of(Project.builder()
				.id(1L)
				.name("name")
				.title(DEFAULT_TITLE)
				.about("about project")
				.logo(null)
				.owner(DEFAULT_USERNAME)
				.publicAccess(true)
				.website(null)
				.license(null)
				.licenseLink(null)
				.organization(Organization.builder().id(1L).build())
				.metas(Collections.emptySet())
				.contacts(Collections.emptySet())
				.changeLogs(Collections.emptySet())
				.isActive(true)
				.createdBy(DEFAULT_USERNAME)
				.createdOn(Instant.now())
				.editedBy(DEFAULT_USERNAME)
				.editedOn(Instant.now())
				.version(0)
				.build()))
			.when(projectRepository).findOneByTitle(DEFAULT_TITLE);
		
		Optional<ProjectDetailedDTO> optional = projectService.getProjectDetailByTitle(DEFAULT_TITLE);
		assertThat(optional).isPresent();
		assertThat(optional.get().getOrganization()).isNotNull();
		assertThat(optional.get().getOrganization().getId()).isEqualTo(1L);
	}

}
