package info.changelogs.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Entity
@Data
@Builder
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ChangeLogContent extends Auditable {
	
	@Enumerated(EnumType.STRING)
	@Column(length = 10, nullable = false)
	private ContentType contentType;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
}
