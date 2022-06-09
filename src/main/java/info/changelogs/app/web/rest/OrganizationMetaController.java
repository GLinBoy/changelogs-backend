package info.changelogs.app.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.OrganizationMetaDTO;
import info.changelogs.app.service.OrganizationMetaServiceApi;

@RestController
@RequestMapping(path = "${application.api-path}/organization-meta")
public class OrganizationMetaController extends GenericController<OrganizationMetaDTO, OrganizationMetaServiceApi> {

	public OrganizationMetaController(OrganizationMetaServiceApi service) {
		super(service);
	}

}
