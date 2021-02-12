package info.changelogs.app.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import info.changelogs.app.dto.ContactDTO;
import info.changelogs.app.entity.Contact;
import info.changelogs.app.repository.ContactRepository;
import info.changelogs.app.service.ContactServiceApi;

@Service
public class ContactServiceImpl
	extends GenericServiceImpl<ContactDTO, Contact, ContactRepository>
	implements ContactServiceApi {

	public ContactServiceImpl(ContactRepository repository, ModelMapper mapper) {
		super(repository, mapper, ContactDTO.class, Contact.class);
	}

}
