package info.changelogs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.changelogs.app.entity.ChangeLogMeta;

public interface ChangeLogMetaRepository extends JpaRepository<ChangeLogMeta, Long> {

}
