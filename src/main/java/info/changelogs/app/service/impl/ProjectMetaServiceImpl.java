package info.changelogs.app.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import info.changelogs.app.dto.ProjectMetaDTO;
import info.changelogs.app.entity.ProjectMeta;
import info.changelogs.app.repository.ProjectMetaRepository;
import info.changelogs.app.service.ProjectMetaServiceApi;

@Service
public class ProjectMetaServiceImpl
	extends GenericServiceImpl<ProjectMetaDTO, ProjectMeta, ProjectMetaRepository>
	implements ProjectMetaServiceApi {

	public ProjectMetaServiceImpl(ProjectMetaRepository repository, ModelMapper mapper) {
		super(repository, mapper, ProjectMetaDTO.class, ProjectMeta.class);
	}

}
