package info.changelogs.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
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
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
	}

}
