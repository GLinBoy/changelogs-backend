package info.changelogs.app.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_ORGANIZATION_NAME", columnNames ={"NAME"}),
		@UniqueConstraint(name = "UNQ_ORGANIZATION_TITLE", columnNames = {"TITLE"}),
		@UniqueConstraint(name = "UNQ_ORGANIZATION_EMAIL", columnNames = {"EMAIL"})
})
public class Organization extends Auditable {
	
	@Column(name = "NAME", length = 128, nullable = false)
	private String name;
	
	@Column(name = "TITLE", length = 128, nullable = false)
	private String title;
	
	@Column(name = "EMAIL", length = 64, nullable = false)
	private String email;
	
	@OneToMany(mappedBy = "organization", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<OrganizationMeta> metas;
	
	@OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
	Set<Project> projects;
}
