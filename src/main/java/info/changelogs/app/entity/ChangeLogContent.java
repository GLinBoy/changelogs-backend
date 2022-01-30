package info.changelogs.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	public ChangeLogContent(Long id, Boolean isActive, String createdBy, String editedBy, LocalDateTime createdOn,
			LocalDateTime editedOn, Integer version, ContentType contentType, String content, ChangeLog changeLog) {
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
