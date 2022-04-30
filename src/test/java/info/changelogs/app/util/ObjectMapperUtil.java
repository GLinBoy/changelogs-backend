package info.changelogs.app.util;

import org.zalando.problem.jackson.ProblemModule;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class ObjectMapperUtil {

	public static final String toJsonString(final Object obj) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper = mapper.findAndRegisterModules();

			// Registered Problem Module
			mapper.registerModules(new ProblemModule(), new ConstraintViolationProblemModule());
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
