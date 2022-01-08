package info.changelogs.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import info.changelogs.app.entity.ChangeLog;

@DataJpaTest
class ChangeLogRepositoryUnitTest {

	@Autowired
	private ChangeLogRepository changeLogRepository;

	private final Pageable pageable = PageRequest.of(0, 1_000);

	@Test
	void contextLoads() {
		assertThat(changeLogRepository).isNotNull();
		assertThat(changeLogRepository.count()).isPositive();
	}

	@Test
	void testFindAllDetailed() {
		Page<ChangeLog> page = changeLogRepository.findAllDetailed(pageable);
		assertThat(page.getTotalElements()).isEqualTo(100);
		assertThat(page.getContent().parallelStream().map(ChangeLog::getId).collect(Collectors.toSet()).size())
				.isEqualTo(100);
		assertThat(page.getContent().stream().anyMatch(cl -> cl.getContents() != null || !cl.getContents().isEmpty()))
				.isTrue();
		assertThat(page.getContent().stream().anyMatch(cl -> !cl.getContents().isEmpty())).isTrue();
		assertThat(page.getContent().stream().anyMatch(cl -> cl.getProject() == null)).isFalse();
		assertThat(page.getContent().stream().anyMatch(
				cl -> cl.getProject().getOrganization() != null && cl.getProject().getOrganization().getId() >= 0L))
						.isTrue();
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
