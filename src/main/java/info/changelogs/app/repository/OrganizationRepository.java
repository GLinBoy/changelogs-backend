package info.changelogs.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import info.changelogs.app.dto.projection.OwnerDTO;
import info.changelogs.app.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

	List<OwnerDTO> findAllByCreatedBy(String username);

}
