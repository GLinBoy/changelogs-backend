package info.changelogs.app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
public class Project {
	private String name;
	private String about;
	private String logo;
	private String logoType;
	private String owner;
	private String ownerEmail;
	private Boolean publicAccess;
	private String website;
	private String readmeLink;
	private String licenseLink;
}
