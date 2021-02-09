package info.changelogs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.changelogs.app.entity.ProjectMeta;

public interface ProjectMetaRepository extends JpaRepository<ProjectMeta, Long> {

}
