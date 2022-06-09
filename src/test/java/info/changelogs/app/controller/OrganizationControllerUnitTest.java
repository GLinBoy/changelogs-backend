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
import info.changelogs.app.web.rest.OrganizationResource;

@ExtendWith(MockitoExtension.class)
class OrganizationControllerUnitTest {

	@InjectMocks
	private OrganizationResource organizationController;

	@Mock
	private OrganizationServiceApi organizationService;

	private final Integer DEFAULT_SIZE = 3;

	@Test
	void contextLoads() {
		assertThat(organizationController).isNotNull();
	}

	@Test
	void testGetOwnerList() {
		doReturn(generateOwnerDTO(DEFAULT_SIZE)).when(organizationService).getOwners(Mockito.any(String.class));

		ResponseEntity<List<OwnerDTO>> responseEntity = organizationController.getOwnerList();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(DEFAULT_SIZE, responseEntity.getBody().size());
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
