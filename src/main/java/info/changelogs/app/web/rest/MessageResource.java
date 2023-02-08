package info.changelogs.app.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.ContactDTO;
import info.changelogs.app.service.ContactServiceApi;

@RestController
@RequestMapping(path = "${application.api-path}/contact")
public class ContactResource extends GenericResource<ContactDTO, ContactServiceApi> {

	public ContactResource(ContactServiceApi service) {
		super(service);
	}

}
