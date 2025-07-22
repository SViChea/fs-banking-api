package kh.edu.icstad.fsbankingapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ServiceException {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleResponseStatusException(ResponseStatusException e) {
        ErrorResponse<?> errorResponse = new ErrorResponse<>(
                e.getReason(),
                e.getStatusCode().value(),
                LocalDateTime.now(),
                e.getReason()
        );

        return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
    }
}
