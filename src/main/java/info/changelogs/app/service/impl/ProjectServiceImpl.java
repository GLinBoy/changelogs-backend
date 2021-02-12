package info.changelogs.app.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import info.changelogs.app.dto.ProjectDTO;
import info.changelogs.app.entity.Project;
import info.changelogs.app.repository.ProjectRepository;
import info.changelogs.app.service.ProjectServiceApi;

@Service
public class ProjectServiceImpl
	extends GenericServiceImpl<ProjectDTO, Project, ProjectRepository>
	implements ProjectServiceApi {

	public ProjectServiceImpl(ProjectRepository repository, ModelMapper mapper) {
		super(repository, mapper, ProjectDTO.class, Project.class);
	}

}
