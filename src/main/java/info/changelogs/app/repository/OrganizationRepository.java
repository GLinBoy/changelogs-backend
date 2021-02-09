package info.changelogs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.changelogs.app.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
