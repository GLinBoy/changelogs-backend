package info.changelogs.app.dto;

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
	
	private String name;
	private String title;
	private String about;
	private String logo;
	private String owner;
	private Boolean publicAccess;
	private String website;
	private String readmeLink;
	private String licenseLink;
	private Long organizationId;

}
