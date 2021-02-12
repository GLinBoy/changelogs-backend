package info.changelogs.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.ChangeLogDTO;
import info.changelogs.app.service.ChangeLogServiceApi;

@RestController
@RequestMapping(path = "/changelog")
public class ChangeLogController extends GenericController<ChangeLogDTO, ChangeLogServiceApi> {

	public ChangeLogController(ChangeLogServiceApi service) {
		super(service);
	}

}
