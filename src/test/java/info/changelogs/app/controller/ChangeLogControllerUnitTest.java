package info.changelogs.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import info.changelogs.app.service.ChangeLogServiceApi;

@ExtendWith(MockitoExtension.class)
class ChangeLogControllerUnitTest {

	@InjectMocks
	private ChangeLogController changeLogController;

	@Mock
	private ChangeLogServiceApi changeLogService;

	@Test
	void contextLoads() {
		assertThat(changeLogController).isNotNull();
	}

	@Test
	void testGetLatest() {
		fail("Not yet implemented");
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
