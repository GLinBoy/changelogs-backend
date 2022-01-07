package info.changelogs.app.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import info.changelogs.app.entity.Project;

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
		Optional<Project> projectOpt = projectRepository.findOneByTitle("Flexidy");
		assertThat(projectOpt).isNotEmpty();
	}

}
