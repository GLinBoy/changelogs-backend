package info.changelogs.app.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.ChangeLogContentDTO;
import info.changelogs.app.service.ChangeLogContentServiceApi;

@RestController
@RequestMapping(path = "${application.api-path}/changelog-content")
public class ChangeLogContentController extends GenericController<ChangeLogContentDTO, ChangeLogContentServiceApi> {

	public ChangeLogContentController(ChangeLogContentServiceApi service) {
		super(service);
	}

}
