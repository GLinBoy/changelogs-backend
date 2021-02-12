package info.changelogs.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.OrganizationDTO;
import info.changelogs.app.service.OrganizationServiceApi;

@RestController
@RequestMapping(path = "/organization")
public class OrganizationController extends GenericController<OrganizationDTO, OrganizationServiceApi>{

	public OrganizationController(OrganizationServiceApi service) {
		super(service);
	}

}
