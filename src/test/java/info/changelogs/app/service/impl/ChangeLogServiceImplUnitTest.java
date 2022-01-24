package info.changelogs.app.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doAnswer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Collections;
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

import info.changelogs.app.dto.ChangeLogContentDTO;
import info.changelogs.app.dto.ChangeLogDTO;
import info.changelogs.app.entity.ChangeLog;
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

	private List<ChangeLog> list;

	@BeforeEach
	void setUp() {
		changeLogService = new ChangeLogServiceImpl(changeLogRepository, modelMapper, em);
	}

	@Test
	void contextLoads() throws Exception {
		assertThat(changeLogService).isNotNull();
	}

	@Test
	void testSaveChangeLogDTO() {
		fail("Not yet implemented");
	}

	@Test
	void testGetLatest() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProjectChangeLogStringStringPageable() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProjectChangeLogStringPageable() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProjectChangeLogVersionStringStringString() {
		fail("Not yet implemented");
	}

	@Test
	void testGetProjectChangeLogVersionStringString() {
		fail("Not yet implemented");
	}

}
