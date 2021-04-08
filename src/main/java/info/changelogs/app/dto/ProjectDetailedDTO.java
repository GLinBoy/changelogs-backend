package info.changelogs.app.dto;

import info.changelogs.app.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
public class ProjectDetailedDTO extends BaseEntity {
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
	
	private OrganizationDTO organizationId;
}
