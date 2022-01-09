package info.changelogs.app.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

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
