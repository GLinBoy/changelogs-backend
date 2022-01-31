package info.changelogs.app.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChangeLogMetaDTO extends MetaDataDTO {

	public ChangeLogMetaDTO() {
		super();
	}

	@Builder
	public ChangeLogMetaDTO(Long id, Boolean isActive, String key, String value, Long changeLogMetaId) {
		super(id, isActive, key, value);
		this.changeLogMetaId = changeLogMetaId;
	}

	private Long changeLogMetaId;

}
