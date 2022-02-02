package info.changelogs.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import info.changelogs.app.dto.OrganizationDTO;
import info.changelogs.app.service.OrganizationServiceApi;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class GenericControllerUnitTest {

	@InjectMocks
	private OrganizationController organizationController;

	@Mock
	private OrganizationServiceApi organizationService;

	private final Long DEFAULT_ID = 10000L;
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

	private List<OrganizationDTO> list;

	@BeforeEach
	void setUp() {
		list = generateOrganizationDTO(DEFAULT_ORGANIZATION_COUNT);

		organizationController = new OrganizationController(organizationService);
	}

	private List<OrganizationDTO> generateOrganizationDTO(Integer number) {
		return IntStream.range(0, number)
				.mapToObj(i -> OrganizationDTO.builder()
						.id(DEFAULT_ID + Long.valueOf(i))
						.isActive(true)
						.name(String.format("%s_%d", DEFAULT_NAME, i))
						.title(String.format("%s_%d", DEFAULT_TITLE, i))
						.slogan(String.format("%s_%d", DEFAULT_SLOGAN, i))
						.website(String.format("https://%s-%d.com", DEFAULT_WEBSITE_DOMAIN, i))
						.email(String.format("info@%s-%d.com", DEFAULT_WEBSITE_DOMAIN, i)).location(DEFAULT_LOCATION)
						.logo(null).verified(Boolean.TRUE).build())
				.collect(Collectors.toList());
	}

	@Test
	void testGetAll() {
		doReturn(new PageImpl<OrganizationDTO>(list)).when(organizationService).getAll(pageable);

		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/api/test");
		ResponseEntity<List<OrganizationDTO>> responseEntity = organizationController.getAll(pageable, request);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getHeaders().getAccessControlExposeHeaders())
			.containsAll(List.of(HttpHeaders.LINK, "X-Total-Count"));
	}

	@Test
	void testGetById() {
		doAnswer(i -> {
			Long id = (Long) i.getArguments()[0];
			return list.stream().filter(o -> o.getId().equals(id)).findAny().orElseThrow();
		}).when(organizationService).getSingleById(DEFAULT_ID);

		ResponseEntity<OrganizationDTO> responseEntity = organizationController.getById(DEFAULT_ID);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody().getId()).isEqualTo(DEFAULT_ID);
	}

	@Test
	void testSave() {
		doAnswer(i -> {
			OrganizationDTO organizationDTO = (OrganizationDTO) i.getArguments()[0];
			Long lastId = list.stream().mapToLong(OrganizationDTO::getId).max().orElse(0L);
			organizationDTO.setId(lastId + 1);
			list.add(organizationDTO);
			return organizationDTO;
		}).when(organizationService).save(Mockito.any(OrganizationDTO.class));

		OrganizationDTO organizationDTO = generateOrganizationDTO(1).get(0);
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.setRequestURI("/api/test");
		
		ResponseEntity<OrganizationDTO> responseEntity = organizationController.save(organizationDTO, request);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(responseEntity.getBody().getId()).isPositive();
		assertThat(responseEntity.getBody().getId())
				.isEqualByComparingTo(list.stream().mapToLong(OrganizationDTO::getId).max().orElse(0L));
	}

	@Test
	void testUpdate() {
		doAnswer(i -> {
			OrganizationDTO organization = (OrganizationDTO) i.getArguments()[0];
			list.removeIf(o -> o.getId().equals(organization.getId()));
			list.add(organization);
			return organization;
		}).when(organizationService).update(Mockito.any(OrganizationDTO.class));

		OrganizationDTO organizationDTO = list.parallelStream()
				.filter(o -> o.getId().equals(DEFAULT_ID))
				.findFirst().orElseThrow();
		organizationDTO.setName(DEFAULT_EDITED_NAME);
		organizationDTO.setTitle(DEFAULT_EDITED_TITLE);
		organizationDTO.setSlogan(DEFAULT_EDITED_SLOGAN);
		organizationDTO.setWebsite(String.format("https://%s.com", DEFAULT_EDITED_WEBSITE_DOMAIN));
		organizationDTO.setEmail(String.format("info@%s.com", DEFAULT_EDITED_WEBSITE_DOMAIN));
		organizationDTO.setLocation(DEFAULT_EDITED_LOCATION);
		
		ResponseEntity<OrganizationDTO> responseEntity = organizationController.update(organizationDTO);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody().getName()).isEqualTo(DEFAULT_EDITED_NAME);
		assertThat(responseEntity.getBody().getTitle()).isEqualTo(DEFAULT_EDITED_TITLE);
		assertThat(responseEntity.getBody().getSlogan()).isEqualTo(DEFAULT_EDITED_SLOGAN);
		assertThat(responseEntity.getBody().getWebsite())
				.isEqualTo(String.format("https://%s.com", DEFAULT_EDITED_WEBSITE_DOMAIN));
		assertThat(responseEntity.getBody().getEmail())
				.isEqualTo(String.format("info@%s.com", DEFAULT_EDITED_WEBSITE_DOMAIN));
		assertThat(responseEntity.getBody().getLocation()).isEqualTo(DEFAULT_EDITED_LOCATION);
	}

	@Test
	void testDeleteById() {
	}

}
