package info.changelogs.app.web.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
final class ExceptionHandling extends ResponseEntityExceptionHandler {

}
