package info.changelogs.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import info.changelogs.app.dto.projection.ProjectMinimizedDTO;
import info.changelogs.app.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	@Query(value = " SELECT p.id AS id, "
			+ " p.name as name, "
			+ " p.title AS title, "
			+ " p.owner AS owner "
			+ " FROM Project p "
			+ " LEFT JOIN p.organization o "
			+ " WHERE p.owner = :username or o.createdBy = :username ",
			countQuery = "SELECT count(p.id) FROM Project p "
					+ " LEFT JOIN p.organization o "
					+ " WHERE p.owner = :username or o.createdBy = :username ")
	Page<ProjectMinimizedDTO> findAllNecessary(@Param("username") String username, Pageable pageable);

}
