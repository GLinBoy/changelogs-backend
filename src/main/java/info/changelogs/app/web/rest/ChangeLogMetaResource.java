package info.changelogs.app.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.ChangeLogMetaDTO;
import info.changelogs.app.service.ChangeLogMetaServiceApi;

@RestController
@RequestMapping(path = "${application.api-path}/changelog-meta")
public class ChangeLogMetaResource extends GenericController<ChangeLogMetaDTO, ChangeLogMetaServiceApi> {

	public ChangeLogMetaResource(ChangeLogMetaServiceApi service) {
		super(service);
	}

}
