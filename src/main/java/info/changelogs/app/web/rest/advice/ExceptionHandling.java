package info.changelogs.app.web.rest.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;

@ControllerAdvice
final class ExceptionHandling implements ProblemHandling {

}
