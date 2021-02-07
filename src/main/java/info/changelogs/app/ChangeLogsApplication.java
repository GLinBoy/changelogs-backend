package info.changelogs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import info.changelogs.app.util.ApplicationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ ApplicationProperties.class })
public class ChangeLogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChangeLogsApplication.class, args);
	}

}
