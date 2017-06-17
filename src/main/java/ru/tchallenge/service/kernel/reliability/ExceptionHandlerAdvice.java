package ru.tchallenge.service.kernel.reliability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ru.tchallenge.service.kernel.utility.correlation.CorrelationContext;
import ru.tchallenge.service.kernel.validation.ValidationException;

public class ExceptionHandlerAdvice {

    @Autowired
    private CorrelationContext correlationContext;

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleValidationException(final ValidationException exception) {
        logAsError(exception);
        return badRequest(exception);
    }

    private ResponseEntity<?> badRequest(final ValidationException exception) {
        return new ResponseEntity<Object>(info(exception), HttpStatus.BAD_REQUEST);
    }

    private ExceptionInfo info(final ValidationException exception) {
        return new ExceptionInfo(
                exception.getId(),
                exception.getCategory().getDescription(),
                exception.getCategory().getTextcode(),
                exception.getViolations());
    }

    private void logAsError(final Throwable throwable) {
        System.out.println(correlationContext.getCorrelation().getId());
    }
}
