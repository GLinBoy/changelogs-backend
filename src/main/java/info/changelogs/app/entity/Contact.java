package info.changelogs.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Contact extends BaseEntity {

	public Contact() {
		super();
	}

	@Builder
	public Contact(Long id, Boolean isActive, String name, String email, String subject, String message,
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
	@JoinColumn(name = "PROJECT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_PROJECT_CONTACT"))
	private Project project;
}
