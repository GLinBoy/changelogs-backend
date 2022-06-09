package info.changelogs.app.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.ContactDTO;
import info.changelogs.app.service.ContactServiceApi;

@RestController
@RequestMapping(path = "${application.api-path}/contact")
public class ContactController extends GenericController<ContactDTO, ContactServiceApi> {

	public ContactController(ContactServiceApi service) {
		super(service);
	}

}
