package info.changelogs.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Entity
@Data
@Builder
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Contact extends BaseEntity {
	
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
