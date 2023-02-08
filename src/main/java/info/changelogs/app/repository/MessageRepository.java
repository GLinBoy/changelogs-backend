package info.changelogs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.changelogs.app.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
