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
		@UniqueConstraint(name = "UNQ_PROJECT_META", columnNames ={"META_KEY", "PROJECT_ID"})
})
public class ProjectMeta extends MetaData {

	public ProjectMeta() {
		super();
	}

	@Builder
	public ProjectMeta(Long id, Boolean isActive, String key, String value, Project project) {
		super(id, isActive, key, value);
		this.project = project;
	}

	@ManyToOne
	@JoinColumn(name = "PROJECT_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_PROJECT_META"))
	private Project project;
}
