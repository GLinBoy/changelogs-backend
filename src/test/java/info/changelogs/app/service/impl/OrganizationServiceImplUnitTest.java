package info.changelogs.app.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import info.changelogs.app.dto.projection.OwnerDTO;
import info.changelogs.app.repository.OrganizationRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OrganizationServiceImplUnitTest {

	@InjectMocks
	private OrganizationServiceImpl organizationService;

	@Mock
	private OrganizationRepository organizationRepository;

	@Mock
	private ModelMapper modelMapper;

	private final String DEFAULT_USERNAME = "test";

	@BeforeEach
	void setUp() {
		organizationService = new OrganizationServiceImpl(organizationRepository, modelMapper);
	}

	@Test
	void contextLoads() throws Exception {
		assertThat(organizationService).isNotNull();
	}

	@Test
	void testGetOwners() {
		doReturn(generateOwnerDTO(3)).when(organizationRepository).findAllByCreatedBy(DEFAULT_USERNAME);
		List<OwnerDTO> owners = organizationService.getOwners(DEFAULT_USERNAME);
		assertThat(owners).isNotEmpty();
	}

	private List<OwnerDTO> generateOwnerDTO(Integer count) {
		return IntStream.range(0, count).mapToObj(i -> {
			ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
			OwnerDTO owner = factory.createProjection(OwnerDTO.class);
			owner.setId(Long.valueOf(1001 + i));
			owner.setName(String.format("%s %d", "name", i));
			owner.setTitle(String.format("%s %d", "title", i));
			return owner;
		}).collect(Collectors.toList());
	}

}
