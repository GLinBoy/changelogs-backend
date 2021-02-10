package info.changelogs.app.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class MetaDataDTO extends BaseDTO {

	private String key;
	private String value;

}
