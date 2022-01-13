package info.changelogs.app.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;

@Entity
@Data
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = { @UniqueConstraint(name = "UNQ_ORGANIZATION_NAME", columnNames = { "NAME" }),
		@UniqueConstraint(name = "UNQ_ORGANIZATION_TITLE", columnNames = { "TITLE" }),
		@UniqueConstraint(name = "UNQ_ORGANIZATION_EMAIL", columnNames = { "EMAIL" }) })
public class Organization extends Auditable {

	Organization() {
		super();
	}

	@Builder
	Organization(Long id, Boolean isActive, String createdBy, String editedBy, LocalDateTime createdOn,
			LocalDateTime editedOn, Integer version, String name, String title, String slogan, String website,
			String email, String location, String logo, Boolean verified, Set<OrganizationMeta> metas,
			Set<Project> projects) {
		super(id, isActive, createdBy, editedBy, createdOn, editedOn, version);
		this.name = name;
		this.title = title;
		this.slogan = slogan;
		this.website = website;
		this.email = email;
		this.location = location;
		this.logo = logo;
		this.verified = verified;
		this.metas = metas;
		this.projects = projects;
	}

	@Column(name = "NAME", length = 32, nullable = false)
	private String name;

	@Column(name = "TITLE", length = 32, nullable = false)
	private String title;

	@Column(name = "SLOGAN", length = 128)
	private String slogan;

	@Column(name = "WEBSITE", length = 64)
	private String website;

	@Column(name = "EMAIL", length = 64, nullable = false)
	private String email;

	@Column(name = "LOCATION", length = 64)
	private String location;

	@Column(name = "LOGO", columnDefinition = "text")
	private String logo;

	@Column(name = "VERIFIED", columnDefinition = "boolean default false")
	private Boolean verified;

	@OneToMany(mappedBy = "organization", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<OrganizationMeta> metas;

	@OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
	Set<Project> projects;
}
