package info.changelogs.app.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ProjectRepositoryUnitTest {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Test
	void contextLoads() {
		assertThat(projectRepository).isNotNull();
	}

	@Test
	void testFindAllNecessary() {
		fail("Not yet implemented");
	}

	@Test
	void testFindOneByTitle() {
		fail("Not yet implemented");
	}

}
