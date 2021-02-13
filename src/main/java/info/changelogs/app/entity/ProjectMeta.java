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
@Builder
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = {
		@UniqueConstraint(name = "UNQ_PROJECT_META", columnNames ={"KEY", "PROJECT_ID"})
})
public class ProjectMeta extends MetaData {

	@ManyToOne
	@JoinColumn(name = "PROJECT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_PROJECT_META"))
	private Project project;
}
