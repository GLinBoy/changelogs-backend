package info.changelogs.app.service.impl;

import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.changelogs.app.dto.ChangeLogDTO;
import info.changelogs.app.dto.ChangeLogDetailedDTO;
import info.changelogs.app.entity.ChangeLog;
import info.changelogs.app.entity.Project;
import info.changelogs.app.repository.ChangeLogRepository;
import info.changelogs.app.service.ChangeLogServiceApi;

@Service
public class ChangeLogServiceImpl
	extends GenericServiceImpl<ChangeLogDTO, ChangeLog, ChangeLogRepository>
	implements ChangeLogServiceApi {
	
	private final EntityManager em;

	public ChangeLogServiceImpl(ChangeLogRepository repository, ModelMapper mapper, EntityManager em) {
		super(repository, mapper, ChangeLogDTO.class, ChangeLog.class);
		this.em = em;
	}
	
	@Override
	public ChangeLogDTO save(ChangeLogDTO changeLogDTO) {
		// FIXME Check project belong to current user or has access to it
		// https://github.com/GLinBoy/changelogs-backend/issues/28
		ChangeLog changeLog = mapper.map(changeLogDTO, ChangeLog.class);
		changeLog.setIsActive(Boolean.TRUE);
		changeLog.setProject(em.getReference(Project.class, changeLogDTO.getProjectId()));
		changeLog.getContents().forEach(c -> c.setChangeLog(changeLog));
		return mapper.map(repository.save(changeLog), ChangeLogDTO.class);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<ChangeLogDetailedDTO> getLatest(Pageable pageable) {
		Page<ChangeLog> page = this.repository.findAllDetailed(pageable);
		return page.map(cl -> mapper.map(cl, ChangeLogDetailedDTO.class));
	}
}
