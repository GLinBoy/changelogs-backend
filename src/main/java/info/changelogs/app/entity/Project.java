package info.changelogs.app.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

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
	
	@Column(length = 128, unique = true, nullable = false)
	private String name;
	
	@Column(columnDefinition = "text")
	private String about;
	
	@Column(columnDefinition = "text")
	private String logo;
	
	@Column(length = 32)
	private String logoType;
	
	@Column(length = 128, nullable = false)
	private String owner;
	
	@Column(length = 128, nullable = false)
	private String ownerEmail;
	
	private Boolean publicAccess;
	
	@Column(length = 128, unique = true, nullable = false)
	private String website;
	
	@Column(length = 128, unique = true, nullable = false)
	private String readmeLink;
	
	@Column(length = 128, unique = true, nullable = false)
	private String licenseLink;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<ProjectMeta> metas;
}
