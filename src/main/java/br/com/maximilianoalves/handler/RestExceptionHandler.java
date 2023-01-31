package br.com.maximilianoalves.handler;

import br.com.maximilianoalves.error.ExpiredJwtException;
import br.com.maximilianoalves.error.ExpiredJwtExceptionDetails;
import br.com.maximilianoalves.error.ResourceNotFoundDetails;
import br.com.maximilianoalves.error.ResourceNotFoundException;
import jakarta.servlet.ServletException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rfnException) {
        ResourceNotFoundDetails resourceNotFoundDetails = ResourceNotFoundDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .details(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();
        return new ResponseEntity<>(resourceNotFoundDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ExpiredJwtException.class, io.jsonwebtoken.ExpiredJwtException.class} )
    public ResponseEntity<?> handleJwtExpiredException(ExpiredJwtException eJwtError) {
        ExpiredJwtExceptionDetails expiredJwtException = ExpiredJwtExceptionDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.UNAUTHORIZED.value())
                .title("Unauthorized")
                .details(eJwtError.getMessage())
                .developerMessage(eJwtError.getClass().getName())
                .build();
        return new ResponseEntity<>(expiredJwtException, HttpStatus.UNAUTHORIZED);
    }
}
