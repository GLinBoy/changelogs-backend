package info.changelogs.app.dto;

import java.time.Instant;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectDetailedDTO extends AuditableDTO {

	public ProjectDetailedDTO() {
		super();
	}

	@Builder
	public ProjectDetailedDTO(Long id, Boolean isActive, String createdBy, String editedBy, Instant createdOn,
			Instant editedOn, Integer version, String name, String title, String about, String logo,
			String owner, Boolean publicAccess, String website, String readmeLink, String license, String licenseLink,
			OrganizationDTO organization) {
		super(id, isActive, createdBy, editedBy, createdOn, editedOn, version);
		this.name = name;
		this.title = title;
		this.about = about;
		this.logo = logo;
		this.owner = owner;
		this.publicAccess = publicAccess;
		this.website = website;
		this.readmeLink = readmeLink;
		this.license = license;
		this.licenseLink = licenseLink;
		this.organization = organization;
	}

	private String name;
	private String title;
	private String about;
	private String logo;
	private String owner;
	private Boolean publicAccess;
	private String website;
	private String readmeLink;
	private String license;
	private String licenseLink;

	private OrganizationDTO organization;
}
