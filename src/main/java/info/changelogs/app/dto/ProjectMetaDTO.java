package info.changelogs.app.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectMetaDTO extends MetaDataDTO {

	public ProjectMetaDTO() {
		super();
	}

	@Builder
	public ProjectMetaDTO(Long id, Boolean isActive, String key, String value, Long projectId) {
		super(id, isActive, key, value);
		this.projectId = projectId;
	}

	private Long projectId;

}
