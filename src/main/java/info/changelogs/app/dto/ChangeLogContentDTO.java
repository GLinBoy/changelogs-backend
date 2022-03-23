package info.changelogs.app.dto;

import java.time.Instant;

import info.changelogs.app.entity.ContentType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChangeLogContentDTO extends AuditableDTO {

	public ChangeLogContentDTO() {
		super();
	}

	@Builder
	public ChangeLogContentDTO(Long id, Boolean isActive, String createdBy, String editedBy, Instant createdOn,
			Instant editedOn, Integer version, ContentType contentType, String content, Long changeLogId) {
		super(id, isActive, createdBy, editedBy, createdOn, editedOn, version);
		this.contentType = contentType;
		this.content = content;
		this.changeLogId = changeLogId;
	}



	private ContentType contentType;
	private String content;
	private Long changeLogId;
}
