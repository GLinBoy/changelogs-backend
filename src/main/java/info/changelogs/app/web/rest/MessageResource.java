package info.changelogs.app.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.MessageDTO;
import info.changelogs.app.service.MessageServiceApi;

@RestController
@RequestMapping(path = "${application.api-path}/messages")
public class MessageResource extends GenericResource<MessageDTO, MessageServiceApi> {

	public MessageResource(MessageServiceApi service) {
		super(service);
	}

}
