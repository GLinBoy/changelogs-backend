package info.changelogs.app.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_ORGANIZATION_META", columnNames ={"KEY", "ORGANIZATION_ID"})
})
public class OrganizationMeta extends MetaData {
	
	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_ORGANIZATION_META"))
	private Organization organization;

}
