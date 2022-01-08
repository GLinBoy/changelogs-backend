package info.changelogs.app.dto;

import java.time.Instant;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;

import info.changelogs.app.entity.BaseEntity;
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
public class ChangeLogDetailedDTO extends BaseEntity {

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
