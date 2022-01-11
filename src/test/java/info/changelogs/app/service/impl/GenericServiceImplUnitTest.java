package info.changelogs.app.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doAnswer;

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
import org.modelmapper.ModelMapper;

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

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testSaveAll() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testGetSingleById() {
		fail("Not yet implemented");
	}

	@Test
	void testCount() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteSingleById() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteSingleByReference() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteAll() {
		fail("Not yet implemented");
	}

}
