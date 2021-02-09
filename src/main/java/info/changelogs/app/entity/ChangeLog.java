package info.changelogs.app.entity;

import java.time.Instant;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

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
	
	@OneToMany(mappedBy = "changeLog", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<ChangeLogMeta> metas;
}
