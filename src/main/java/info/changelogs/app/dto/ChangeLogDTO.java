package info.changelogs.app.dto;

import java.time.Instant;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;

import info.changelogs.app.entity.Platform;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldNameConstants
@EqualsAndHashCode(callSuper = true)
public class ChangeLogDTO extends BaseDTO {

	@Size(max = 32)
	@NotBlank(message = "Version number is mandatory")
	private String versionNo;
	
	@Size(max = 32)
	private String buildVersion;
	
	@NotNull(message = "Release date is mandatory")
	@JsonDeserialize(using = InstantDeserializer.class)
	@JsonSerialize(using = InstantSerializer.class)
	private Instant releaseDate;
	
	@Size(max = 128)
	@NotBlank(message = "Publisher is mandatory")
	private String publisher;
	
	@Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
	@Size(min = 8, max = 64)
	@NotBlank(message = "Contact is mandatory")
	private String contact;
	
	@NotNull(message = "Force update is mandatory")
	private Boolean forceUpdate;

	@NotNull(message = "Platform is mandatory")
	private Platform platform;
	
	@NotNull(message = "Project is mandatory")
	private Long projectId;

	Set<ChangeLogContentDTO> contents;
}
