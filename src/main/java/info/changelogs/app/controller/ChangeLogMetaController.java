package info.changelogs.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.ChangeLogMetaDTO;
import info.changelogs.app.service.ChangeLogMetaServiceApi;

@RestController
@RequestMapping(path = "${application.api-path}/changelog-meta")
public class ChangeLogMetaController extends GenericController<ChangeLogMetaDTO, ChangeLogMetaServiceApi> {

	public ChangeLogMetaController(ChangeLogMetaServiceApi service) {
		super(service);
	}

}
