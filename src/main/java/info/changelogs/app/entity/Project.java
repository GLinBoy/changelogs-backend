package info.changelogs.app.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Entity
@Data
@Builder
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Project extends Auditable{
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
