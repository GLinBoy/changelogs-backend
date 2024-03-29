package info.changelogs.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import info.changelogs.app.dto.ProjectDTO;
import info.changelogs.app.dto.ProjectDetailedDTO;
import info.changelogs.app.dto.projection.ProjectMinimizedDTO;

public interface ProjectServiceApi extends GenericServiceApi<ProjectDTO> {

	Page<ProjectMinimizedDTO> getAllNecessary(String username, Pageable pageable);

	Optional<ProjectDetailedDTO> getProjectDetailByTitle(String title);

}
