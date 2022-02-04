package info.changelogs.app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import info.changelogs.app.dto.projection.OwnerDTO;
import info.changelogs.app.service.OrganizationServiceApi;

@ExtendWith(MockitoExtension.class)
class OrganizationControllerUnitTest {

	@InjectMocks
	private OrganizationController organizationController;

	@Mock
	private OrganizationServiceApi organizationService;

	private final Integer DEFAULT_SIZE = 3;

	@Test
	void contextLoads() {
		assertThat(organizationController).isNotNull();
	}

	@Test
	void testGetOwnerList() {
		fail("Not yet implemented");
	}

}
