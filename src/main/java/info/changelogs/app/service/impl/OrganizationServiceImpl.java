package info.changelogs.app.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import info.changelogs.app.dto.OrganizationDTO;
import info.changelogs.app.entity.Organization;
import info.changelogs.app.repository.OrganizationRepository;
import info.changelogs.app.service.OrganizationServiceApi;

@Service
public class OrganizationServiceImpl
	extends GenericServiceImpl<OrganizationDTO, Organization, OrganizationRepository>
	implements OrganizationServiceApi {

	public OrganizationServiceImpl(OrganizationRepository repository, ModelMapper mapper) {
		super(repository, mapper);
	}

}
