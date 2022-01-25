package info.changelogs.app.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import info.changelogs.app.dto.ChangeLogContentDTO;
import info.changelogs.app.dto.ChangeLogDTO;
import info.changelogs.app.dto.ChangeLogDetailedDTO;
import info.changelogs.app.entity.ChangeLog;
import info.changelogs.app.entity.ChangeLogContent;
import info.changelogs.app.entity.ContentType;
import info.changelogs.app.entity.Platform;
import info.changelogs.app.entity.Project;
import info.changelogs.app.repository.ChangeLogRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ChangeLogServiceImplUnitTest {

	@InjectMocks
	private ChangeLogServiceImpl changeLogService;

	@Mock
	private ChangeLogRepository changeLogRepository;

	@Mock
	private ModelMapper modelMapper;

	@Mock
	private EntityManager em;

	private final Integer DEFAULT_CHANGELOG_COUNT = 3;

	private final Pageable pageable = PageRequest.of(0, 1_000);

	private List<ChangeLog> list;

	@BeforeEach
	void setUp() {
		list = generateChangeLog(DEFAULT_CHANGELOG_COUNT);

		modelMapper = new ModelMapper();

		changeLogService = new ChangeLogServiceImpl(changeLogRepository, modelMapper, em);
	}

	private List<ChangeLog> generateChangeLog(Integer counter) {
		return IntStream.range(0, counter).mapToObj(i -> ChangeLog.builder().id(Long.valueOf(i))
				.versionNo(String.valueOf(i)).buildVersion(String.valueOf(i)).releaseDate(Instant.now())
				.publisher(String.format("publisher_%d", i)).contact("email@email.com").forceUpdate(Boolean.FALSE)
				.platform(Platform.API).project(Project.builder().id(Long.valueOf(i)).build())
				.contents(Collections.emptySet()).createdBy("admin").createdOn(LocalDateTime.now()).editedBy("admin")
				.editedOn(LocalDateTime.now()).build()).collect(Collectors.toList());
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
	void contextLoads() throws Exception {
		assertThat(changeLogService).isNotNull();
	}

	@Test
	void testSaveChangeLogDTO() {
		doAnswer(i -> {
			ChangeLog changeLog = (ChangeLog) i.getArguments()[0];
			Long lastId = list.stream().mapToLong(ChangeLog::getId).max().orElse(0L);
			changeLog.setId(lastId + 1);
			changeLog.getContents().forEach(c -> c.setId(1000L));
			list.add(changeLog);
			return changeLog;
		}).when(changeLogRepository).save(Mockito.any(ChangeLog.class));

		ChangeLogDTO organizationDTO = generateChangeLogDTO(1).get(0);
		ChangeLogDTO savedOrganizationDTO = changeLogService.save(organizationDTO);
		assertThat(savedOrganizationDTO.getId()).isPositive();
		assertThat(savedOrganizationDTO.getId())
				.isEqualByComparingTo(list.stream().mapToLong(ChangeLog::getId).max().orElse(0L));
		assertThat(savedOrganizationDTO.getContents().stream().anyMatch(c -> c.getId() == null)).isFalse();
	}

	@Test
	void testGetLatest() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProjectChangeLogByUsernameAndTitleAndPageable() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProjectChangeLogByTitlePageable() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProjectChangeLogVersionByUsernameAndProjectTitleAndVersion() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProjectChangeLogVersionByProjectTitleAndVersion() {
		fail("Not yet implemented");
	}

}
