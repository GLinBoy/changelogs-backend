package info.changelogs.app.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrganizationMetaDTO extends MetaDataDTO {

	public OrganizationMetaDTO() {
		super();
	}

	@Builder
	public OrganizationMetaDTO(Long id, Boolean isActive, String key, String value, Long organizationId) {
		super(id, isActive, key, value);
		this.organizationId = organizationId;
	}

	private Long organizationId;

}
