package info.changelogs.app.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class MetaDataDTO extends BaseDTO {

	MetaDataDTO() {
		super();
	}

	MetaDataDTO(Long id, Boolean isActive, String key, String value) {
		super(id, isActive);
		this.key = key;
		this.value = value;
	}

	private String key;
	private String value;

}
