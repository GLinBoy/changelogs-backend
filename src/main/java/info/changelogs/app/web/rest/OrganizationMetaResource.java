package info.changelogs.app.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.OrganizationMetaDTO;
import info.changelogs.app.service.OrganizationMetaServiceApi;

@RestController
@RequestMapping(path = "${application.api-path}/organization-metas")
public class OrganizationMetaResource extends GenericResource<OrganizationMetaDTO, OrganizationMetaServiceApi> {

	public OrganizationMetaResource(OrganizationMetaServiceApi service) {
		super(service);
	}

}
