package info.changelogs.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@FieldNameConstants
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrganizationDTO extends BaseDTO {

	@Size(min = 4, max = 32)
	@NotBlank(message = "Name is mandatory")
	private String name;

	@Size(min = 4, max = 32)
	@NotBlank(message = "Title is mandatory")
	private String title;

	@Email(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
	@Size(min = 8, max = 64)
	@NotBlank(message = "Email is mandatory")
	private String email;

}
