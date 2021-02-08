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
public class Organization extends Auditable {
	
	@Column(length = 128, unique = true, nullable = false)
	private String name;
	
	@Column(length = 128, unique = true, nullable = false)
	private String title;
	
	@Column(length = 64, unique = true, nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "organization", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<OrganizationMeta> metas;
	
	@OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
	Set<Project> projects;
}
