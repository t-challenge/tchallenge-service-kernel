package ru.tchallenge.service.kernel.reliability;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ru.tchallenge.service.kernel.utility.correlation.CorrelationContext;
import ru.tchallenge.service.kernel.validation.ValidationException;
import ru.tchallenge.service.kernel.validation.ValidationExceptionCategory;
import ru.tchallenge.service.kernel.validation.ViolationInfo;

@ControllerAdvice
public class ValidationExceptionHandler {

    private final Log commonLog = LogFactory.getLog("tchallenge.service.kernel.common");
    private final Log securityLog = LogFactory.getLog("tchallenge.service.kernel.security");

    @Autowired
    private CorrelationContext correlationContext;

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(final ValidationException exception) {
        if (exception.getCategory() == ValidationExceptionCategory.ACCESS) {
            securityLog.warn("", exception);
            return unauthorized(exception);
        } else {
            commonLog.warn("", exception);
            return badRequest(exception);
        }
    }

    private ResponseEntity<?> badRequest(final ValidationException exception) {
        return responseEntity(exception, HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<?> notFound(final ValidationException exception) {
        return responseEntity(exception, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<?> unauthorized(final ValidationException exception) {
        return responseEntity(exception, HttpStatus.UNAUTHORIZED);
    }

    private ResponseEntity<?> responseEntity(final ValidationException exception,
                                             final HttpStatus httpStatus) {
        final String id = exception.getId();
        final String description = exception.getCategory().getDescription();
        final String textcode = exception.getCategory().getTextcode();
        final Collection<? extends ViolationInfo> violations = exception.getViolations();
        final ExceptionInfo info = new ExceptionInfo(id, description, textcode, violations);
        return new ResponseEntity<>(info, httpStatus);
    }
}
