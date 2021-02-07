package info.changelogs.app.entity;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
public class ChangeLog {
	private String versionNo;
	private String buildVersion;
	private Instant releaseDate;
	private String publisher;
	private String contact;
	private Boolean forceUpdate;
	private String platform;
}
