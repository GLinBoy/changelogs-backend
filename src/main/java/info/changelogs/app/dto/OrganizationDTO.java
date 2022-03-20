package info.changelogs.app.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrganizationDTO extends AuditableDTO {

	public OrganizationDTO() {
		super();
	}

	@Builder
	public OrganizationDTO(Long id, Boolean isActive, String createdBy, String editedBy, LocalDateTime createdOn,
			LocalDateTime editedOn, Integer version, String name, String title, String slogan, String website,
			String email, String location, String logo, Boolean verified) {
		super(id, isActive, createdBy, editedBy, createdOn, editedOn, version);
		this.name = name;
		this.title = title;
		this.slogan = slogan;
		this.website = website;
		this.email = email;
		this.location = location;
		this.logo = logo;
		this.verified = verified;
	}

	@Size(min = 4, max = 32)
	@NotBlank(message = "Name is mandatory")
	private String name;

	@Size(min = 4, max = 32)
	@NotBlank(message = "Title is mandatory")
	private String title;
	
	@Size(max = 128)
	private String slogan;
	
	@URL
	@Size(max = 64)
	private String website;

	@Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
	@Size(min = 8, max = 64)
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	@Size(max = 64)
	private String location;
	
	private String logo;
	
	private Boolean verified;

}
