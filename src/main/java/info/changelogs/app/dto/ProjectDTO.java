package info.changelogs.app.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProjectDTO extends AuditableDTO {

	public ProjectDTO() {
		super();
	}

	@Builder
	public ProjectDTO(Long id, Boolean isActive, String createdBy, String editedBy, LocalDateTime createdOn,
			LocalDateTime editedOn, Integer version,
			@Size(min = 4, max = 128) @NotBlank(message = "Name is mandatory") String name,
			@Size(min = 4, max = 128) @NotBlank(message = "Title is mandatory") String title, String about, String logo,
			@Size(max = 128) @NotBlank(message = "Owner is mandatory") String owner, Boolean publicAccess,
			@URL @Size(max = 128) String website, @URL @Size(max = 128) String readmeLink,
			@Size(max = 32) String license, @URL @Size(max = 128) String licenseLink, Long organizationId) {
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
		this.organizationId = organizationId;
	}

	@Size(min = 4, max = 128)
	@NotBlank(message = "Name is mandatory")
	private String name;

	@Size(min = 4, max = 128)
	@NotBlank(message = "Title is mandatory")
	private String title;

	private String about;

	private String logo;

	@Size(max = 128)
	@NotBlank(message = "Owner is mandatory")
	private String owner;

	private Boolean publicAccess;

	@URL
	@Size(max = 128)
	private String website;

	@URL
	@Size(max = 128)
	private String readmeLink;

	@Size(max = 32)
	private String license;

	@URL
	@Size(max = 128)
	private String licenseLink;

	private Long organizationId;

}
