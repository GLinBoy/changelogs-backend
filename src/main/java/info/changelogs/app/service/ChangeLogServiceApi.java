package info.changelogs.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import info.changelogs.app.dto.ChangeLogDTO;
import info.changelogs.app.dto.ChangeLogDetailedDTO;

public interface ChangeLogServiceApi extends GenericServiceApi<ChangeLogDTO> {

	Page<ChangeLogDetailedDTO> getLatest(Pageable pageable);

	Page<ChangeLogDTO> getProjectChangeLog(String username, String projectTitle, Pageable pageable);
	
	Page<ChangeLogDTO> getProjectChangeLog(String projectTitle, Pageable pageable);

	List<ChangeLogDTO> getProjectChangeLogVersion(String username, String projectTitle, String version);

	List<ChangeLogDTO> getProjectChangeLogVersion(String projectTitle, String version);

}
