package info.changelogs.app.dto;

import java.time.Instant;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;

import info.changelogs.app.entity.Platform;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ChangeLogDetailedDTO extends BaseDTO {

	public ChangeLogDetailedDTO() {
		super();
	}

	@Builder
	public ChangeLogDetailedDTO(Long id, Boolean isActive, String versionNo, String buildVersion, Instant releaseDate,
			String publisher, String contact, Boolean forceUpdate, Platform platform, ProjectDetailedDTO project,
			Set<ChangeLogContentDTO> contents) {
		super(id, isActive);
		this.versionNo = versionNo;
		this.buildVersion = buildVersion;
		this.releaseDate = releaseDate;
		this.publisher = publisher;
		this.contact = contact;
		this.forceUpdate = forceUpdate;
		this.platform = platform;
		this.project = project;
		this.contents = contents;
	}

	private String versionNo;
	private String buildVersion;

	@JsonDeserialize(using = InstantDeserializer.class)
	@JsonSerialize(using = InstantSerializer.class)
	private Instant releaseDate;
	private String publisher;
	private String contact;
	private Boolean forceUpdate;
	private Platform platform;

	private ProjectDetailedDTO project;

	Set<ChangeLogContentDTO> contents;
}
