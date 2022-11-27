package info.changelogs.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
