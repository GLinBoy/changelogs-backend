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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@EqualsAndHashCode(callSuper = true, exclude = "contents")
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_CHANGELOG_VERSION", columnNames ={"VERSION_NO", "PLATFORM", "PROJECT_ID"}),
		@UniqueConstraint(name = "UNQ_CHANGELOG_BUILD", columnNames = {"BUILD_VERSION", "PLATFORM", "PROJECT_ID"})
})
public class ChangeLog extends Auditable {
	
	@Column(name = "VERSION_NO", length = 32, nullable = false)
	private String versionNo;
	
	@Column(name = "BUILD_VERSION", length = 32)
	private String buildVersion;
	
	@Column(nullable = false)
	private Instant releaseDate;
	
	@Column(length = 128, nullable = false)
	private String publisher;
	
	@Column(length = 64, nullable = false)
	private String contact;
	
	private Boolean forceUpdate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "PLATFORM", length = 8, nullable = false)
	private Platform platform;
	
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_PROJECT_CHANGELOG"))
	private Project project;
	
	@OneToMany(mappedBy = "changeLog", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<ChangeLogMeta> metas;
	
	@OneToMany(mappedBy = "changeLog", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<ChangeLogContent> contents;
}
