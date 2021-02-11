package info.changelogs.app.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import info.changelogs.app.dto.OrganizationMetaDTO;
import info.changelogs.app.entity.OrganizationMeta;
import info.changelogs.app.repository.OrganizationMetaRepository;
import info.changelogs.app.service.OrganizationMetaServiceApi;

@Service
public class OrganizationMetaServiceImpl
	extends GenericServiceImpl<OrganizationMetaDTO, OrganizationMeta, OrganizationMetaRepository>
	implements OrganizationMetaServiceApi {

	public OrganizationMetaServiceImpl(OrganizationMetaRepository repository, ModelMapper mapper) {
		super(repository, mapper);
	}

}
