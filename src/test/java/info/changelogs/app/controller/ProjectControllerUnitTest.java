package info.changelogs.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doReturn;

import java.util.List;
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

import info.changelogs.app.dto.projection.ProjectMinimizedDTO;
import info.changelogs.app.service.ProjectServiceApi;

@ExtendWith(MockitoExtension.class)
class ProjectControllerUnitTest {
	
	@InjectMocks
	private ProjectController projectController;
	
	@Mock
	private ProjectServiceApi projectService;


	private final Integer DEFAULT_SIZE = 3;
	private final Pageable pageable = PageRequest.of(0, 1_000);

	@Test
	void contextLoads() {
		assertThat(projectController).isNotNull();
	}

	@Test
	void testGetUserProjectList() {
		fail("Not yet implemented");

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
