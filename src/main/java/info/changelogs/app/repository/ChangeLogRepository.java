package info.changelogs.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import info.changelogs.app.entity.ChangeLog;

public interface ChangeLogRepository extends JpaRepository<ChangeLog, Long> {

	@Query(value = " SELECT cl from ChangeLog cl "
			+ " LEFT JOIN FETCH cl.contents "
			+ " LEFT JOIN FETCH cl.project p "
			+ " LEFT JOIN FETCH p.organization ",
		countQuery = "SELECT count(cl) FROM ChangeLog cl ")
	Page<ChangeLog> findAllDetailed(Pageable pageable);

	@Query(value = " SELECT cl from ChangeLog cl "
			+ " LEFT JOIN FETCH cl.contents "
			+ " LEFT JOIN FETCH cl.project p "
			+ " WHERE p.owner = ?1 AND p.title = ?2 ",
			countQuery = "SELECT count(cl) FROM ChangeLog cl "
					+ " LEFT JOIN cl.contents "
					+ " LEFT JOIN cl.project p "
					+ " WHERE p.owner = ?1 AND p.title = ?2 ")
	Page<ChangeLog> findAllByUsernameAndProjectTitle(String username, String projectTitle,
			Pageable pageable);

	@Query(value = " SELECT cl from ChangeLog cl "
			+ " LEFT JOIN FETCH cl.contents "
			+ " LEFT JOIN FETCH cl.project p "
			+ " WHERE p.owner = ?1 AND p.title = ?2 AND cl.versionNo = ?3 ",
			countQuery = "SELECT count(cl) FROM ChangeLog cl "
					+ " LEFT JOIN cl.contents "
					+ " LEFT JOIN cl.project p "
					+ " WHERE p.owner = ?1 AND p.title = ?2 AND p.versionNo = ?3 ")
	List<ChangeLog> findAllByUsernameAndProjectTitleAndVersion(String username, String projectTitle, String version);

	@Query(value = " SELECT cl from ChangeLog cl "
        + " LEFT JOIN FETCH cl.contents "
        + " LEFT JOIN FETCH cl.project p "
        + " WHERE p.title = ?1 ",
        countQuery = "SELECT count(cl) FROM ChangeLog cl "
                + " LEFT JOIN cl.contents "
                + " LEFT JOIN cl.project p "
                + " WHERE p.title = ?1 ")
	Page<ChangeLog> findAllByProjectTitle(String projectTitle, Pageable pageable);

	@Query(value = " SELECT cl from ChangeLog cl "
        + " LEFT JOIN FETCH cl.contents "
        + " LEFT JOIN FETCH cl.project p "
        + " WHERE p.title = ?1 AND cl.versionNo = ?2 ",
        countQuery = "SELECT count(cl) FROM ChangeLog cl "
                + " LEFT JOIN cl.contents "
                + " LEFT JOIN cl.project p "
                + " WHERE p.title = ?1 AND p.versionNo = ?2 ")
	List<ChangeLog> findAllByProjectTitleAndVersion(String projectTitle, String version);

}
