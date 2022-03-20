package info.changelogs.app.dto;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = false)
public abstract class AuditableDTO extends BaseDTO {
	AuditableDTO() {
		super();
	}

	AuditableDTO(Long id, Boolean isActive, String createdBy, String editedBy, LocalDateTime createdOn,
			LocalDateTime editedOn, Integer version) {
		super(id, isActive);
		this.createdBy = createdBy;
		this.editedBy = editedBy;
		this.createdOn = createdOn;
		this.editedOn = editedOn;
		this.version = version;
	}

	private String createdBy;

	private String editedBy;

	private LocalDateTime createdOn;

	private LocalDateTime editedOn;

	private Integer version;
}
