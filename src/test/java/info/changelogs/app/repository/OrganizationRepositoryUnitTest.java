package info.changelogs.app.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class OrganizationRepositoryUnitTest {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Test
	void contextLoads() {
		assertThat(organizationRepository).isNotNull();
	}

	@Test
	void testFindAllByCreatedBy() {
		fail("Not yet implemented");
	}

}
