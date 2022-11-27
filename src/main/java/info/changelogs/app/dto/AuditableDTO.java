package info.changelogs.app.dto;

import java.time.Instant;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class AuditableDTO extends BaseDTO {
	AuditableDTO() {
		super();
	}

	AuditableDTO(Long id, Boolean isActive, String createdBy, String editedBy, Instant createdOn,
			Instant editedOn, Integer version) {
		super(id, isActive);
		this.createdBy = createdBy;
		this.editedBy = editedBy;
		this.createdOn = createdOn;
		this.editedOn = editedOn;
		this.version = version;
	}

	private String createdBy;

	private String editedBy;

	private Instant createdOn;

	private Instant editedOn;

	private Integer version;
}
