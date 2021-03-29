package info.changelogs.app.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		@UniqueConstraint(name = "UNQ_PROJECT_NAME", columnNames ={"NAME", "OWNER"}),
		@UniqueConstraint(name = "UNQ_PROJECT_TITLE", columnNames ={"TITLE", "OWNER"})
})
public class Project extends Auditable{
	
	@Column(name = "NAME", length = 128, nullable = false)
	private String name;
	
	@Column(name = "TITLE", length = 128, nullable = false)
	private String title;
	
	@Column(columnDefinition = "text")
	private String about;
	
	@Column(columnDefinition = "text")
	private String logo;
	
	@Column(name="OWNER", length = 128, nullable = false)
	private String owner;
	
	private Boolean publicAccess;
	
	@Column(length = 128)
	private String website;
	
	@Column(length = 32)
	private String license;
	
	@Column(length = 128)
	private String licenseLink;
	
	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID", foreignKey = @ForeignKey(name = "FK_ORGANIZATION_PROJECT"))
	private Organization organization;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<ProjectMeta> metas;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<Contact> contacts;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	Set<ChangeLog> changeLogs;
}
