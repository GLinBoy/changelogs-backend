package info.changelogs.app.dto;

import java.time.Instant;

import info.changelogs.app.entity.Platform;
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
public class ChangeLogDTO extends BaseDTO {

	private String versionNo;
	private String buildVersion;
	private Instant releaseDate;
	private String publisher;
	private String contact;
	private Boolean forceUpdate;
	private Platform platform;
	private Long projectId;

}
