package info.changelogs.app.entity;

import java.time.Instant;

import javax.persistence.Entity;

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
public class ChangeLog extends Auditable {
	private String versionNo;
	private String buildVersion;
	private Instant releaseDate;
	private String publisher;
	private String contact;
	private Boolean forceUpdate;
	private String platform;
}
