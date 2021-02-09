package info.changelogs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.changelogs.app.entity.ChangeLog;

public interface ChangeLogRepository extends JpaRepository<ChangeLog, Long> {

}
