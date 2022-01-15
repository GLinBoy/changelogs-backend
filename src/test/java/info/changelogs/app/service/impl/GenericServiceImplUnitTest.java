package info.changelogs.app.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.server.ResponseStatusException;

import info.changelogs.app.dto.OrganizationDTO;
import info.changelogs.app.entity.Organization;
import info.changelogs.app.repository.OrganizationRepository;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class GenericServiceImplUnitTest {

	@InjectMocks
	private OrganizationServiceImpl organizationService;

	@Mock
	private OrganizationRepository organizationRepository;

	@Mock
	private ModelMapper modelMapper;

	private final Long DEFAULT_ID = 10001L;
	private final String DEFAULT_NAME = "name";
	private final String DEFAULT_TITLE = "title";
	private final String DEFAULT_SLOGAN = "slogan";
	private final String DEFAULT_WEBSITE_DOMAIN = "website";
	private final String DEFAULT_LOCATION = "Tallin, Estonia";
	
	private final String DEFAULT_EDITED_NAME = "edited name";
	private final String DEFAULT_EDITED_TITLE = "edited title";
	private final String DEFAULT_EDITED_SLOGAN = "edited slogan";
	private final String DEFAULT_EDITED_WEBSITE_DOMAIN = "edited-website";
	private final String DEFAULT_EDITED_LOCATION = "Tartu, Estonia";
	
	private final Integer DEFAULT_ORGANIZATION_COUNT = 3;
	private final Pageable pageable = PageRequest.of(0, 1_000);

	@BeforeEach
	void setUp() {
		List<Organization> list = generateOrganization(DEFAULT_ORGANIZATION_COUNT);
		modelMapper = new ModelMapper();
		doAnswer(i -> {
			Organization organization = (Organization)i.getArguments()[0];
			organization.setId(DEFAULT_ID);
			return organization;
		}).when(organizationRepository).save(Mockito.any(Organization.class));
		doReturn(Optional.of(list.get(0))).when(organizationRepository).findById(DEFAULT_ID);
		organizationService = new OrganizationServiceImpl(organizationRepository, modelMapper);
	}
	
	private List<OrganizationDTO> generateOrganizationDTO(Integer number) {
		return IntStream.range(0, number)
				.mapToObj(i -> OrganizationDTO.builder()
							.name(String.format("%s_%d", DEFAULT_NAME, i))
							.title(String.format("%s_%d", DEFAULT_TITLE, i))
							.slogan(String.format("%s_%d", DEFAULT_SLOGAN, i))
							.website(String.format("https://%s-%d.com", DEFAULT_WEBSITE_DOMAIN, i))
							.email(String.format("info@%s-%d.com", DEFAULT_WEBSITE_DOMAIN, i))
							.location(DEFAULT_LOCATION)
							.logo(null)
							.verified(Boolean.TRUE)
							.build()
				)
				.collect(Collectors.toList());
	}
	
	private List<Organization> generateOrganization(Integer number) {
		return IntStream.range(0, number)
				.mapToObj(i -> Organization.builder()
						.id(DEFAULT_ID + i)
							.name(String.format("%s_%d", DEFAULT_NAME, i))
							.title(String.format("%s_%d", DEFAULT_TITLE, i))
							.slogan(String.format("%s_%d", DEFAULT_SLOGAN, i))
							.website(String.format("https://%s-%d.com", DEFAULT_WEBSITE_DOMAIN, i))
							.email(String.format("info@%s-%d.com", DEFAULT_WEBSITE_DOMAIN, i))
							.location(DEFAULT_LOCATION)
							.logo(null)
							.verified(Boolean.TRUE)
							.createdBy("test_user")
							.createdOn(LocalDateTime.now())
							.editedBy("test_user")
							.editedOn(LocalDateTime.now())
							.build()
				)
				.collect(Collectors.toList());
	}

	@Test
	void testSave() {
		OrganizationDTO organizationDTO = generateOrganizationDTO(1).get(0);
		OrganizationDTO savedOrganizationDTO = organizationService.save(organizationDTO);
		assertThat(savedOrganizationDTO.getId()).isEqualTo(DEFAULT_ID);
	}

	@Test
	void testSaveAll() {
		List<OrganizationDTO> list = generateOrganizationDTO(5);
		list = organizationService.saveAll(list);
		assertThat(list.parallelStream().allMatch(o -> o.getId() != null && o.getId() > 0)).isTrue();
	}

	@Test
	void testUpdate() {
		OrganizationDTO organizationDTO = organizationService.getSingleById(DEFAULT_ID);
		organizationDTO.setName(DEFAULT_EDITED_NAME);
		organizationDTO.setTitle(DEFAULT_EDITED_TITLE);
		organizationDTO.setSlogan(DEFAULT_EDITED_SLOGAN);
		organizationDTO.setWebsite(String.format("https://%s.com", DEFAULT_WEBSITE_DOMAIN));
		organizationDTO.setEmail(String.format("info@%s.com", DEFAULT_EDITED_WEBSITE_DOMAIN));
		organizationDTO.setLocation(DEFAULT_EDITED_LOCATION);
		organizationService.save(organizationDTO);
		OrganizationDTO editedOrganizationDTO = organizationService.getSingleById(DEFAULT_ID);
		assertThat(editedOrganizationDTO.getName()).isEqualTo(DEFAULT_EDITED_NAME);
		assertThat(editedOrganizationDTO.getTitle()).isEqualTo(DEFAULT_EDITED_TITLE);
		assertThat(editedOrganizationDTO.getSlogan()).isEqualTo(DEFAULT_EDITED_SLOGAN);
		assertThat(editedOrganizationDTO.getWebsite()).isEqualTo(String.format("https://%s.com", DEFAULT_WEBSITE_DOMAIN));
		assertThat(editedOrganizationDTO.getEmail()).isEqualTo(String.format("info@%s.com", DEFAULT_EDITED_WEBSITE_DOMAIN));
		assertThat(editedOrganizationDTO.getLocation()).isEqualTo(DEFAULT_EDITED_LOCATION);
	}

	@Test
	void testGetSingleById() {
		OrganizationDTO organizationDTO = organizationService.getSingleById(DEFAULT_ID);
		assertThat(organizationDTO).isNotNull();
		assertThat(organizationDTO.getId()).isEqualTo(DEFAULT_ID);
	}

	@Test
	void testCount() {
		assertThat(organizationService.count()).isEqualTo(DEFAULT_ORGANIZATION_COUNT);
	}

	@Test
	void testGetAll() {
		Page<OrganizationDTO> all = organizationService.getAll(pageable);
		assertThat(all.getTotalElements()).isEqualTo(DEFAULT_ORGANIZATION_COUNT);
	}

	@Test
	void testDeleteSingleById() {
		organizationService.deleteSingleById(DEFAULT_ID);
		assertThat(organizationRepository.count()).isEqualTo(DEFAULT_ORGANIZATION_COUNT - 1);
		ResponseStatusException thrown = assertThrows(ResponseStatusException.class,
				() -> organizationService.getSingleById(DEFAULT_ID));
		assertEquals(404, thrown.getRawStatusCode());
	}

	@Test
	void testDeleteSingleByReference() {
		OrganizationDTO organizationDTO = organizationService.getSingleById(DEFAULT_ID);
		organizationService.deleteSingleByReference(organizationDTO);
		assertThat(organizationRepository.count()).isEqualTo(DEFAULT_ORGANIZATION_COUNT - 1);
		ResponseStatusException thrown = assertThrows(ResponseStatusException.class,
				() -> organizationService.getSingleById(DEFAULT_ID));
		assertEquals(404, thrown.getRawStatusCode());
	}

	@Test
	void testDeleteAll() {
		organizationService.deleteAll();
		assertEquals(0, organizationService.count());
	}

}
