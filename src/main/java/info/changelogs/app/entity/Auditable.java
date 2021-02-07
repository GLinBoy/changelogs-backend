package info.changelogs.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = false)
public abstract class Auditable extends BaseEntity {

	@CreatedBy
	@Column(name = "CREATED_BY", updatable = false, nullable = false)
	private Long createdBy;

	@LastModifiedBy
	@Column(name = "EDITED_BY", nullable = false)
	private Long editedBy;

	@CreatedDate
	@Column(name = "CREATED_ON", updatable = false, nullable = false)
	private LocalDateTime createdOn;

	@LastModifiedDate
	@Column(name = "EDITED_ON", nullable = false)
	private LocalDateTime editedOn;

	@Version
	@Column(name = "VERSION", nullable = false)
	private Long version;

}
