package info.changelogs.app.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.changelogs.app.dto.OrganizationDTO;
import info.changelogs.app.dto.projection.OwnerDTO;
import info.changelogs.app.entity.Organization;
import info.changelogs.app.repository.OrganizationRepository;
import info.changelogs.app.service.OrganizationServiceApi;

@Service
public class OrganizationServiceImpl
	extends GenericServiceImpl<OrganizationDTO, Organization, OrganizationRepository>
	implements OrganizationServiceApi {

	public OrganizationServiceImpl(OrganizationRepository repository, ModelMapper mapper) {
		super(repository, mapper, OrganizationDTO.class, Organization.class);
	}

	@Override
	@Transactional(readOnly = true)
	public List<OwnerDTO> getOwners(String username) {
		return this.repository.findAllByCreatedBy(username);
	}

}
