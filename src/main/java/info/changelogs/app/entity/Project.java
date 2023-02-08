package info.changelogs.app.entity;

import java.time.Instant;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = { @UniqueConstraint(name = "UNQ_PROJECT_NAME", columnNames = { "NAME", "OWNER" }),
		@UniqueConstraint(name = "UNQ_PROJECT_TITLE", columnNames = { "TITLE", "OWNER" }) })
public class Project extends Auditable {

	public Project() {
		super();
	}

	@Builder
	public Project(Long id, Boolean isActive, String createdBy, String editedBy, Instant createdOn,
			Instant editedOn, Integer version, String name, String title, String about, String logo, String owner,
			Boolean publicAccess, String website, String license, String licenseLink, Organization organization,
			Set<ProjectMeta> metas, Set<Message> messages, Set<ChangeLog> changeLogs) {
		super(id, isActive, createdBy, editedBy, createdOn, editedOn, version);
		this.name = name;
		this.title = title;
		this.about = about;
		this.logo = logo;
		this.owner = owner;
		this.publicAccess = publicAccess;
		this.website = website;
		this.license = license;
		this.licenseLink = licenseLink;
		this.organization = organization;
		this.metas = metas;
		this.messages = messages;
		this.changeLogs = changeLogs;
	}

	@Column(name = "NAME", length = 128, nullable = false)
	private String name;

	@Column(name = "TITLE", length = 128, nullable = false)
	private String title;

	@Column(columnDefinition = "text")
	private String about;

	@Column(columnDefinition = "text")
	private String logo;

	@Column(name = "OWNER", length = 128, nullable = false)
	private String owner;

	private Boolean publicAccess;

	@Column(length = 128)
	private String website;

	@Column(length = 32)
	private String license;

	@Column(length = 128)
	private String licenseLink;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZATION_ID", foreignKey = @ForeignKey(name = "FK_ORGANIZATION_PROJECT"))
	private Organization organization;

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<ProjectMeta> metas;

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Message> messages;

	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<ChangeLog> changeLogs;
}
