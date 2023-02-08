package info.changelogs.app.dto;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MessageDTO extends AuditableDTO {

	public MessageDTO() {
		super();
	}

	@Builder
	public MessageDTO(Long id, Boolean isActive, String createdBy, String editedBy, Instant createdOn,
			Instant editedOn, Integer version, String name, String email, String subject, String message,
			Long projectId) {
		super(id, isActive, createdBy, editedBy, createdOn, editedOn, version);
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.projectId = projectId;
	}

	private String name;
	private String email;
	private String subject;
	private String message;
	private Long projectId;

}
