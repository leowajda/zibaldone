package com.tutego.ch_09.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.net.URI;

@ControllerAdvice
class GlobalControllerAdvice {

    @ExceptionHandler // 3. local exception handling through an @ExceptionHandler
    public ResponseEntity<String> indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle("The index is out of bound");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setType(URI.create("https://docs.oracle.com/en/java/javase/17/docs/api/java.base/" + "java/lang/IndexOutOfBoundsException.html"));
        return ResponseEntity.of(problemDetail).build();
    }

    @ExceptionHandler // A TypeMismatchException raised while resolving a controller method argument
    public ResponseEntity<?> yearMonthMisformatted(MethodArgumentTypeMismatchException e) {
        var problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("The format of the argument '" + e.getName() + "' is wrong");
        problem.setDetail("The format of '" + e.getValue() + "' is invalid. The form at string must match ISO 8601 format 'YYYY-MM', like '2025-03'");
        problem.setType(URI.create("https://www.iso.org/iso-8601-date-and-time-format.html"));
        return ResponseEntity.of(problem).build();
    }

}