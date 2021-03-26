package info.changelogs.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.OrganizationDTO;
import info.changelogs.app.dto.projection.OwnerDTO;
import info.changelogs.app.service.OrganizationServiceApi;

@RestController
@RequestMapping(path = "/organization")
public class OrganizationController extends GenericController<OrganizationDTO, OrganizationServiceApi>{

	public OrganizationController(OrganizationServiceApi service) {
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
