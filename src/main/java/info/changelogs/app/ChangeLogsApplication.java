package info.changelogs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import info.changelogs.app.util.ApplicationInformation;
import info.changelogs.app.util.ApplicationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ ApplicationProperties.class, ApplicationInformation.class })
@EnableAutoConfiguration(exclude = ErrorMvcAutoConfiguration.class)
public class ChangeLogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChangeLogsApplication.class, args);
	}

}
