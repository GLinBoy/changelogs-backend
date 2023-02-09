package info.changelogs.app.web.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.OrganizationDTO;
import info.changelogs.app.dto.projection.OwnerDTO;
import info.changelogs.app.service.OrganizationServiceApi;

@RestController
@RequestMapping(path = "${application.api-path}/organizations")
public class OrganizationResource extends GenericResource<OrganizationDTO, OrganizationServiceApi>{

	public OrganizationResource(OrganizationServiceApi service) {
		super(service);
	}

	@GetMapping("/owner")
	public ResponseEntity<List<OwnerDTO>> getOwnerList() {
		// FIXME Get user from Security
		// https://github.com/GLinBoy/changelogs-backend/issues/22
		List<OwnerDTO> owners = this.service.getOwners("anonymouse");
		return ResponseEntity.ok(owners);
	}

}
