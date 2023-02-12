package info.changelogs.app.dto;

import java.time.Instant;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import info.changelogs.app.entity.Platform;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChangeLogDTO extends AuditableDTO {

	public ChangeLogDTO() {
		super();
	}

	@Builder
	public ChangeLogDTO(Long id, Boolean isActive, String createdBy, String editedBy, Instant createdOn,
			Instant editedOn, Integer version,
			@Size(max = 32) @NotBlank(message = "Version number is mandatory") String versionNo,
			@Size(max = 32) String buildVersion, @NotNull(message = "Release date is mandatory") Instant releaseDate,
			@Size(max = 128) @NotBlank(message = "Publisher is mandatory") String publisher,
			@Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
			@Size(min = 8, max = 64) @NotBlank(message = "Contact is mandatory") String contact,
			@NotNull(message = "Force update is mandatory") Boolean forceUpdate,
			@NotNull(message = "Platform is mandatory") Platform platform,
			@NotNull(message = "Project is mandatory") Long projectId, Set<ChangeLogContentDTO> contents) {
		super(id, isActive, createdBy, editedBy, createdOn, editedOn, version);
		this.versionNo = versionNo;
		this.buildVersion = buildVersion;
		this.releaseDate = releaseDate;
		this.publisher = publisher;
		this.contact = contact;
		this.forceUpdate = forceUpdate;
		this.platform = platform;
		this.projectId = projectId;
		this.contents = contents;
	}

	@Size(max = 32)
	@NotBlank(message = "Version number is mandatory")
	private String versionNo;
	
	@Size(max = 32)
	private String buildVersion;
	
	@NotNull(message = "Release date is mandatory")
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
