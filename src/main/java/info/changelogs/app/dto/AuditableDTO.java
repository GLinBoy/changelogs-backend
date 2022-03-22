package info.changelogs.app.dto;

import java.time.Instant;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;

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

	@JsonDeserialize(using = InstantDeserializer.class)
	@JsonSerialize(using = InstantSerializer.class)
	private Instant createdOn;

	@JsonDeserialize(using = InstantDeserializer.class)
	@JsonSerialize(using = InstantSerializer.class)
	private Instant editedOn;

	private Integer version;
}
