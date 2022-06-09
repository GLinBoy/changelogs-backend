package info.changelogs.app.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.ChangeLogContentDTO;
import info.changelogs.app.service.ChangeLogContentServiceApi;

@RestController
@RequestMapping(path = "${application.api-path}/changelog-content")
public class ChangeLogContentResource extends GenericResource<ChangeLogContentDTO, ChangeLogContentServiceApi> {

	public ChangeLogContentResource(ChangeLogContentServiceApi service) {
		super(service);
	}

}
