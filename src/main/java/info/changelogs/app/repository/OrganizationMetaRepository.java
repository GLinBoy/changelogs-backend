package info.changelogs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.changelogs.app.entity.OrganizationMeta;

public interface OrganizationMetaRepository extends JpaRepository<OrganizationMeta, Long> {

}
