package info.changelogs.app.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@MappedSuperclass
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public abstract class BaseEntity {

	BaseEntity() {
	}

	BaseEntity(Long id, Boolean isActive) {
		this.id = id;
		this.isActive = isActive;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "IS_ACTIVE", nullable = false)
	private Boolean isActive;
}
