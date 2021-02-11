package info.changelogs.app.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import info.changelogs.app.dto.ChangeLogMetaDTO;
import info.changelogs.app.entity.ChangeLogMeta;
import info.changelogs.app.repository.ChangeLogMetaRepository;
import info.changelogs.app.service.ChangeLogMetaServiceApi;

@Service
public class ChangeLogMetaServiceImpl
	extends GenericServiceImpl<ChangeLogMetaDTO, ChangeLogMeta, ChangeLogMetaRepository>
	implements ChangeLogMetaServiceApi {

	public ChangeLogMetaServiceImpl(ChangeLogMetaRepository repository, ModelMapper mapper) {
		super(repository, mapper);
	}

}
