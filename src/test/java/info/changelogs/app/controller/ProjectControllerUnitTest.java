package info.changelogs.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import info.changelogs.app.dto.ProjectDetailedDTO;
import info.changelogs.app.dto.projection.ProjectMinimizedDTO;
import info.changelogs.app.entity.Organization;
import info.changelogs.app.entity.Project;
import info.changelogs.app.service.ProjectServiceApi;

@ExtendWith(MockitoExtension.class)
class ProjectControllerUnitTest {
	
	@InjectMocks
	private ProjectController projectController;
	
	@Mock
	private ProjectServiceApi projectService;



	private final String DEFAULT_USERNAME = "admin";
	private final String DEFAULT_TITLE = "title";
	private final Integer DEFAULT_SIZE = 3;
	private final Pageable pageable = PageRequest.of(0, 1_000);

	@Test
	void contextLoads() {
		assertThat(projectController).isNotNull();
	}

	@Test
	void testGetUserProjectList() {
		doReturn(new PageImpl<ProjectMinimizedDTO>(generateProjectMinimizedDTO(DEFAULT_SIZE)))
			.when(projectService).getAllNecessary(Mockito.any(String.class), Mockito.any(Pageable.class));

		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/api/project/minimized");
		
		ResponseEntity<List<ProjectMinimizedDTO>> responseEntity = projectController.getUserProjectList(pageable, request);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(DEFAULT_SIZE, responseEntity.getBody().size());
		assertThat(responseEntity.getHeaders().getAccessControlExposeHeaders())
			.containsAll(List.of(HttpHeaders.LINK, "X-Total-Count"));
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
			.when(projectService).getProjectDetailByTitle(DEFAULT_TITLE);
		
		ResponseEntity<ProjectDetailedDTO> responseEntity = projectController.getProjectDetailByTitle(DEFAULT_TITLE);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertThat(responseEntity.getBody().getOrganization()).isNotNull();
		assertThat(responseEntity.getBody().getOrganization().getId()).isEqualTo(1L);
	}

}
