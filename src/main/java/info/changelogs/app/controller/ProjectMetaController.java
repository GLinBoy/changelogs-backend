package info.changelogs.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.ProjectMetaDTO;
import info.changelogs.app.service.ProjectMetaServiceApi;

@RestController
@RequestMapping(path = "${application.api-path}/project-meta")
public class ProjectMetaController extends GenericController<ProjectMetaDTO, ProjectMetaServiceApi> {

	public ProjectMetaController(ProjectMetaServiceApi service) {
		super(service);
	}

}
