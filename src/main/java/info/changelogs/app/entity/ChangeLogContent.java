package info.changelogs.app.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;

@Entity
@Data
@FieldNameConstants
@EqualsAndHashCode(callSuper = true, exclude = "changeLog")
public class ChangeLogContent extends Auditable {

	public ChangeLogContent() {
		super();
	}

	@Builder
	public ChangeLogContent(Long id, Boolean isActive, String createdBy, String editedBy, Instant createdOn,
			Instant editedOn, Integer version, ContentType contentType, String content, ChangeLog changeLog) {
		super(id, isActive, createdBy, editedBy, createdOn, editedOn, version);
		this.contentType = contentType;
		this.content = content;
		this.changeLog = changeLog;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private ContentType contentType;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	@ManyToOne
	@JoinColumn(name = "CHANGELOG_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_CHANGELOG_CONTENT"))
	private ChangeLog changeLog;
}
