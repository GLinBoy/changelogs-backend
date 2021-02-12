package info.changelogs.app.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import info.changelogs.app.dto.ChangeLogDTO;
import info.changelogs.app.entity.ChangeLog;
import info.changelogs.app.repository.ChangeLogRepository;
import info.changelogs.app.service.ChangeLogServiceApi;

@Service
public class ChangeLogServiceImpl
	extends GenericServiceImpl<ChangeLogDTO, ChangeLog, ChangeLogRepository>
	implements ChangeLogServiceApi {

	public ChangeLogServiceImpl(ChangeLogRepository repository, ModelMapper mapper) {
		super(repository, mapper, ChangeLogDTO.class, ChangeLog.class);
	}

}
