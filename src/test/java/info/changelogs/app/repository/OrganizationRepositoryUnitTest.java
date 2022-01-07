package info.changelogs.app.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import info.changelogs.app.dto.projection.OwnerDTO;

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
		assertThat(organizationRepository.count()).isPositive();
		List<OwnerDTO> owners = organizationRepository.findAllByCreatedBy("anonymouse");
		assertThat(owners).isNotEmpty();
		assertThat(owners.size()).isEqualTo(3);
	}

}
