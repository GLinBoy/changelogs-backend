package info.changelogs.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseDTO {

	BaseDTO() {
	}

	BaseDTO(Long id, Boolean isActive) {
		this.id = id;
		this.isActive = isActive;
	}

	private Long id;
	private Boolean isActive;

}
