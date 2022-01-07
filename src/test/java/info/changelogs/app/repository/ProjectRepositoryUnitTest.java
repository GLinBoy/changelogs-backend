package info.changelogs.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import info.changelogs.app.dto.projection.ProjectMinimizedDTO;
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
		Page<ProjectMinimizedDTO> projectsPage = projectRepository
				.findAllNecessary("anonymouse", PageRequest.of(0, 1_000));
		assertThat(projectsPage.getTotalElements()).isPositive();
		assertThat(projectsPage.getTotalElements()).isEqualTo(5);
	}

	@Test
	void testFindAllNecessaryByDoesntExistUsername() {
		Page<ProjectMinimizedDTO> projectsPage = projectRepository
				.findAllNecessary("anonymouse_01", PageRequest.of(0, 1_000));
		assertThat(projectsPage.getTotalElements()).isZero();
	}

	@Test
	void testFindOneByTitle() {
		Optional<Project> projectOpt = projectRepository.findOneByTitle("Flexidy");
		assertThat(projectOpt).isNotEmpty();
	}

	@Test
	void testFindOneByDoesntExistTitle() {
		Optional<Project> projectOpt = projectRepository.findOneByTitle("TEST");
		assertThat(projectOpt).isEmpty();
	}

}
