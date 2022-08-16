package info.changelogs.app.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_ORGANIZATION_META", columnNames = { "META_KEY", "ORGANIZATION_ID" }) })
public class OrganizationMeta extends MetaData {

	public OrganizationMeta() {
		super();
	}

	@Builder
	public OrganizationMeta(Long id, Boolean isActive, String key, String value, Organization organization) {
		super(id, isActive, key, value);
		this.organization = organization;
	}

	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_ORGANIZATION_META"))
	private Organization organization;

}
