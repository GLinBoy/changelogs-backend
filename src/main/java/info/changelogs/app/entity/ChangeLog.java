package info.changelogs.app.entity;

import java.time.Instant;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(length = 32, unique = true, nullable = false)
	private String versionNo;
	
	@Column(length = 32, unique = true)
	private String buildVersion;
	
	@Column(nullable = false)
	private Instant releaseDate;
	
	@Column(length = 128, nullable = false)
	private String publisher;
	
	@Column(length = 128, nullable = false)
	private String contact;
	
	private Boolean forceUpdate;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 8, nullable = false)
	private Platform platform;
	
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_PROJECT_CHANGELOG"))
	private Project project;
	
	@OneToMany(mappedBy = "changeLog", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<ChangeLogMeta> metas;
}
