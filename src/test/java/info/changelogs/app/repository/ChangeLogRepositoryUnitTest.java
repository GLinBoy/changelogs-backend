package info.changelogs.app.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ChangeLogRepositoryUnitTest {

	@Autowired
	private ChangeLogRepository changeLogRepository;

	@Test
	void contextLoads() {
		assertThat(changeLogRepository).isNotNull();
	}

	@Test
	void testFindAllDetailed() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAllByUsernameAndProjectTitle() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAllByUsernameAndProjectTitleAndVersion() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAllByProjectTitle() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAllByProjectTitleAndVersion() {
		fail("Not yet implemented");
	}

}
