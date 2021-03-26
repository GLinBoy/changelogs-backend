package info.changelogs.app.service;

import java.util.List;

import info.changelogs.app.dto.OrganizationDTO;
import info.changelogs.app.dto.projection.OwnerDTO;

public interface OrganizationServiceApi extends GenericServiceApi<OrganizationDTO> {

	List<OwnerDTO> getOwners(String string);

}
