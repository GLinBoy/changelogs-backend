package info.changelogs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.changelogs.app.entity.ChangeLogContent;

public interface ChangeLogContentRepository extends JpaRepository<ChangeLogContent, Long> {

}
