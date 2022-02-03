package info.changelogs.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doReturn;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import info.changelogs.app.dto.ChangeLogContentDTO;
import info.changelogs.app.dto.ChangeLogDTO;
import info.changelogs.app.dto.ChangeLogDetailedDTO;
import info.changelogs.app.entity.ContentType;
import info.changelogs.app.entity.Platform;
import info.changelogs.app.service.ChangeLogServiceApi;

@ExtendWith(MockitoExtension.class)
class ChangeLogControllerUnitTest {

	@InjectMocks
	private ChangeLogController changeLogController;

	@Mock
	private ChangeLogServiceApi changeLogService;

	private final Integer DEFAULT_CHANGELOG_COUNT = 3;
	private final String DEFAULT_USERNAME = "admin";
	private final String DEFAULT_TITLE = "title";
	private final String DEFAULT_VERSION = "1.2.3";

	private final Pageable pageable = PageRequest.of(0, 1_000);

	private List<ChangeLogDTO> list;

	@BeforeEach
	void setUp() {
		list = generateChangeLogDTO(DEFAULT_CHANGELOG_COUNT);

		changeLogController = new ChangeLogController(changeLogService);
	}

	private List<ChangeLogDTO> generateChangeLogDTO(Integer counter) {
		return IntStream.range(0, counter)
				.mapToObj(i -> ChangeLogDTO.builder().versionNo(String.valueOf(i)).buildVersion(String.valueOf(i))
						.releaseDate(Instant.now()).publisher(String.format("publisher_%d", i))
						.contact("email@email.com").forceUpdate(Boolean.FALSE).platform(Platform.API)
						.projectId(Long.valueOf(i)).contents(generateChangeLogContentDTO()).build())
				.collect(Collectors.toList());
	}

	private Set<ChangeLogContentDTO> generateChangeLogContentDTO() {
		return Set.of(
				ChangeLogContentDTO.builder().contentType(ContentType.ADDED).content("added many features!!!").build(),
				ChangeLogContentDTO.builder().contentType(ContentType.REMOVED).content("removed a few APIs!!!").build(),
				ChangeLogContentDTO.builder().contentType(ContentType.FIXED).content("fixed all bugs ;-)").build());
	}

	@Test
	void contextLoads() {
		assertThat(changeLogController).isNotNull();
	}

	@Test
	void testGetLatest() {
		doReturn(new PageImpl<ChangeLogDTO>(list)).when(changeLogService).getLatest(pageable);

		Page<ChangeLogDetailedDTO> latest = changeLogService.getLatest(pageable);
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/api/changelog");
		
		ResponseEntity<List<ChangeLogDetailedDTO>> responseEntity = changeLogController.getLatest(pageable, request);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertThat(latest.getContent()).isNotEmpty();
		assertThat(latest.getTotalElements()).isEqualTo(list.size());
		assertThat(latest.getContent().stream().anyMatch(c -> c.getProject() == null || c.getProject().getId() == null))
				.isFalse();
		assertThat(latest.getContent().stream().anyMatch(c -> c.getContents() == null || c.getContents().isEmpty()))
				.isFalse();
	}

	@Test
	void testGetProjectChangeLog() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProjectChangeLogVersion() {
		fail("Not yet implemented");
	}

}
