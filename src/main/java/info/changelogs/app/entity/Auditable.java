package info.changelogs.app.entity;

import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = false)
public abstract class Auditable extends BaseEntity {

	Auditable() {
		super();
	}

	Auditable(Long id, Boolean isActive, String createdBy, String editedBy, Instant createdOn,
			Instant editedOn, Integer version) {
		super(id, isActive);
		this.createdBy = createdBy;
		this.editedBy = editedBy;
		this.createdOn = createdOn;
		this.editedOn = editedOn;
		this.version = version;
	}

	@CreatedBy
	@Column(name = "CREATED_BY", updatable = false, nullable = false)
	private String createdBy;

	@LastModifiedBy
	@Column(name = "EDITED_BY", nullable = false)
	private String editedBy;

	@CreatedDate
	@Column(name = "CREATED_ON", updatable = false, nullable = false)
	private Instant createdOn;

	@LastModifiedDate
	@Column(name = "EDITED_ON", nullable = false)
	private Instant editedOn;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Integer version;

}
