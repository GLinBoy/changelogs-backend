package info.changelogs.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.ContactDTO;
import info.changelogs.app.service.ContactServiceApi;

@RestController
@RequestMapping(path = "/contact")
public class ContactController extends GenericController<ContactDTO, ContactServiceApi> {

	public ContactController(ContactServiceApi service) {
		super(service);
	}

}
