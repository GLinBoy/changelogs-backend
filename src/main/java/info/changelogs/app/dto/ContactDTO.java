package info.changelogs.app.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ContactDTO extends BaseDTO {

	public ContactDTO() {
		super();
	}

	@Builder
	public ContactDTO(Long id, Boolean isActive, String name, String email, String subject, String message,
			Long projectId) {
		super(id, isActive);
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
