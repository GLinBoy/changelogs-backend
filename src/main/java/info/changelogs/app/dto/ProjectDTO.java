package info.changelogs.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProjectDTO extends BaseDTO{
	
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
