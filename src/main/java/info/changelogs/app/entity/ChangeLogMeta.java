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
@EqualsAndHashCode(callSuper = true, exclude = "changeLog")
@Table(uniqueConstraints = { @UniqueConstraint(name = "UNQ_CHANGELOG_META", columnNames = { "META_KEY", "CHANGELOG_ID" }) })
public class ChangeLogMeta extends MetaData {

	public ChangeLogMeta() {
		super();
	}

	@Builder
	public ChangeLogMeta(Long id, Boolean isActive, String key, String value, ChangeLog changeLog) {
		super(id, isActive, key, value);
		this.changeLog = changeLog;
	}

	@ManyToOne
	@JoinColumn(name = "CHANGELOG_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_CHANGELOG_META"))
	private ChangeLog changeLog;

}
