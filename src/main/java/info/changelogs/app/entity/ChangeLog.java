package info.changelogs.app.entity;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;

@Entity
@Data
@FieldNameConstants
@EqualsAndHashCode(callSuper = true, exclude = { "contents", "metas", "project" })
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_CHANGELOG_VERSION", columnNames = { "VERSION_NO", "PLATFORM", "PROJECT_ID" }),
		@UniqueConstraint(name = "UNQ_CHANGELOG_BUILD", columnNames = { "BUILD_VERSION", "PLATFORM", "PROJECT_ID" }) })
public class ChangeLog extends Auditable {

	public ChangeLog() {
		super();
	}

	@Builder
	public ChangeLog(Long id, Boolean isActive, String createdBy, String editedBy, Instant createdOn,
			Instant editedOn, Integer version, String versionNo, String buildVersion, Instant releaseDate,
			String publisher, String contact, Boolean forceUpdate, Platform platform, Project project,
			Set<ChangeLogMeta> metas, Set<ChangeLogContent> contents) {
		super(id, isActive, createdBy, editedBy, createdOn, editedOn, version);
		this.versionNo = versionNo;
		this.buildVersion = buildVersion;
		this.releaseDate = releaseDate;
		this.publisher = publisher;
		this.contact = contact;
		this.forceUpdate = forceUpdate;
		this.platform = platform;
		this.project = project;
		this.metas = metas;
		this.contents = contents;
	}

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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_PROJECT_CHANGELOG"))
	private Project project;

	@OneToMany(mappedBy = "changeLog", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<ChangeLogMeta> metas;

	@OneToMany(mappedBy = "changeLog", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<ChangeLogContent> contents;
}
