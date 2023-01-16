package info.changelogs.app.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {

	@Bean
	AuditorAware<String> auditorProvider() {
		return new SpringSecurityAuditAwareImpl();
	}
}

class SpringSecurityAuditAwareImpl implements AuditorAware<String> {

	@Override
	// TODO This method must be update after adding Spring Security
	public Optional<String> getCurrentAuditor() {
		return Optional.of("anonymous");
	}
}
