package info.changelogs.app.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class ChangeLogMeta extends MetaData {
	
	@ManyToOne
	@JoinColumn(name = "CHANGELOG_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_CHANGELOG_META"))
	private ChangeLog changeLog;

}
