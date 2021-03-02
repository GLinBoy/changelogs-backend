package info.changelogs.app.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "info.app", ignoreUnknownFields = false)
public final class ApplicationInformation {

	private String name;
	private String description;
	private String version;
	private String license;
	private String licenseUrl;
	private String githubUrl;

}
