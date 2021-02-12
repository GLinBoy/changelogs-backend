package info.changelogs.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.ProjectDTO;
import info.changelogs.app.service.ProjectServiceApi;

@RestController
@RequestMapping(path = "/project")
public class ProjectController extends GenericController<ProjectDTO, ProjectServiceApi> {

	public ProjectController(ProjectServiceApi service) {
		super(service);
	}

}
