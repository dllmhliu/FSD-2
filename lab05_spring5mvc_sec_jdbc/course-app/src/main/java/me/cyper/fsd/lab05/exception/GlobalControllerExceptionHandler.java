package me.cyper.fsd.lab05.exception;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.cyper.fsd.lab05.util.Result;

/**
 * Global Exception Handler.
 */
@ControllerAdvice
@RestController
class GlobalControllerExceptionHandler {

    @Autowired
    protected MessageSource messageSource;

    /**
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = { BusinessException.class, ServletException.class })
    public Result handleClientError(Exception e) {
        System.err.println("global: " + e.getMessage());
        return new Result(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    /**
     * 
     * Uncaught system exceptions (code: 500).
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Result handleInternalServerError(Exception e) {
        e.printStackTrace();
        return new Result(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

}
