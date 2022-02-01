package info.changelogs.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
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

	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	void testGetById() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	void testGenericController() {
		fail("Not yet implemented");
	}

}
