package info.changelogs.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import info.changelogs.app.dto.ChangeLogDTO;
import info.changelogs.app.dto.ChangeLogDetailedDTO;

public interface ChangeLogServiceApi extends GenericServiceApi<ChangeLogDTO> {

	Page<ChangeLogDetailedDTO> getLatest(Pageable pageable);

}
