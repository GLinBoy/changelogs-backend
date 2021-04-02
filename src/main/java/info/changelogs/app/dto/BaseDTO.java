package info.changelogs.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseDTO {

	private Long id;
	private Boolean isActive;

}
