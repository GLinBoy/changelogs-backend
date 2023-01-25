package info.changelogs.app.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.changelogs.app.dto.ProjectMetaDTO;
import info.changelogs.app.service.ProjectMetaServiceApi;

@RestController
@RequestMapping(path = "${application.api-path}/project-meta")
public class ProjectMetaResource extends GenericResource<ProjectMetaDTO, ProjectMetaServiceApi> {

	public ProjectMetaResource(ProjectMetaServiceApi service) {
		super(service);
	}

}
