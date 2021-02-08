package info.changelogs.app.entity;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EqualsAndHashCode(callSuper = true)
public abstract class MetaData extends BaseEntity {
	
	@Column(length = 128, unique = true, nullable = false)
	private String key;
	
	@Column(length = 128, unique = true, nullable = false)
	private String value;
}
