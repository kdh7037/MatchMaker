package gfhouse.matchmaker.exception;

import gfhouse.matchmaker.view.exception.ErrorView;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalErrorHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorView exceptionHandler(Exception e, HttpServletRequest request) {
        ErrorView errorView = new ErrorView();
        errorView.setMessage(ExceptionUtils.getMessage(e.getCause()));
        errorView.setPath(request.getRequestURI());

        return errorView;
    }
}
