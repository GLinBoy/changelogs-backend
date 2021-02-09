package info.changelogs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.changelogs.app.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
