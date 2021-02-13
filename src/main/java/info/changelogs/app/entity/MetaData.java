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
	
	@Column(name = "KEY", length = 128, nullable = false)
	private String key;
	
	@Column(name = "VALUE", length = 128, nullable = false)
	private String value;
}
