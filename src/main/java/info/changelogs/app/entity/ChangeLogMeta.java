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
@EqualsAndHashCode(callSuper = true, exclude = "changeLog")
@Table(uniqueConstraints = { @UniqueConstraint(name = "UNQ_CHANGELOG_META", columnNames = { "KEY", "CHANGELOG_ID" }) })
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
