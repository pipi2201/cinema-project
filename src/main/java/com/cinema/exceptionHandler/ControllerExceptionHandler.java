package com.cinema.exceptionHandler;

import com.cinema.customExceptions.*;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ProblemDetail hasMovieScreening(HasMovieScreeningException e) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problem.setTitle("Movie Scening in Hall");
        problem.setDetail(e.getMessage());
        return problem;
    }

    @ExceptionHandler
    public ProblemDetail emptyOptional(EmptyOptionalException e) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problem.setTitle("Optional not found");
        problem.setDetail(e.getMessage());
        return problem;
    }

    @ExceptionHandler
    public ProblemDetail capacityMet(MaxCapacityException e) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problem.setTitle("Max capacity");
        problem.setDetail(e.getMessage());
        return problem;
    }
    @ExceptionHandler
    public ProblemDetail noMovieVersionMatch(MovieVersionUpdateException e) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problem.setTitle("Movie Versions Do Not Match");
        problem.setDetail(e.getMessage());
        return problem;
    }

    @ExceptionHandler
    public ProblemDetail unsupportedMovieVersion(UnsupportedVersionException e) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        problem.setTitle("Movie Version Not Supported");
        problem.setDetail(e.getMessage());
        return problem;
    }
}
