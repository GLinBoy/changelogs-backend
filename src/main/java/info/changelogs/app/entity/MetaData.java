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
	
	MetaData() {
		super();
	}

	MetaData(Long id, Boolean isActive, String key, String value) {
		super(id, isActive);
		this.key = key;
		this.value = value;
	}

	@Column(name = "META_KEY", length = 128, nullable = false)
	private String key;
	
	@Column(name = "META_VALUE", length = 128, nullable = false)
	private String value;
}
