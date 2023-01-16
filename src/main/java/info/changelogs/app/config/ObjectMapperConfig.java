package info.changelogs.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.zalando.problem.jackson.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ObjectMapperConfig {

	@Bean
	@Primary
	ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper = mapper.findAndRegisterModules();
		
		// Registered Problem Module
		mapper.registerModules(new ProblemModule(),
				new ConstraintViolationProblemModule());
		return mapper;
	}
}
