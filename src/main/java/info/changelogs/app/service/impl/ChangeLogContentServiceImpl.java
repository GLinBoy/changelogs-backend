package info.changelogs.app.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import info.changelogs.app.dto.ChangeLogContentDTO;
import info.changelogs.app.entity.ChangeLogContent;
import info.changelogs.app.repository.ChangeLogContentRepository;
import info.changelogs.app.service.ChangeLogContentServiceApi;

@Service
public class ChangeLogContentServiceImpl
	extends GenericServiceImpl<ChangeLogContentDTO, ChangeLogContent, ChangeLogContentRepository>
	implements ChangeLogContentServiceApi {

	public ChangeLogContentServiceImpl(ChangeLogContentRepository repository, ModelMapper mapper) {
		super(repository, mapper);
	}

}
