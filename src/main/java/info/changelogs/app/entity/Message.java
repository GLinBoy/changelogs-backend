package info.changelogs.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Message extends BaseEntity {

	public Message() {
		super();
	}

	@Builder
	public Message(Long id, Boolean isActive, String name, String email, String subject, String message,
			Project project) {
		super(id, isActive);
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.project = project;
	}

	@Column(length = 128, nullable = false)
	private String name;

	@Column(length = 128, nullable = false)
	private String email;

	@Column(length = 128, nullable = false)
	private String subject;

	@Column(columnDefinition = "text", nullable = false)
	private String message;

	@ManyToOne
	@JoinColumn(name = "PROJECT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_PROJECT_MESSAGE"))
	private Project project;
}
