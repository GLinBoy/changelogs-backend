package info.changelogs.app.dto;

import info.changelogs.app.entity.ContentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
public class ChangeLogContentDTO extends BaseDTO {

	private ContentType contentType;
	private String content;
	private Long changeLogId;
}
