package info.changelogs.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.changelogs.app.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
