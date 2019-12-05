package pl.dawidkaszuba.homeBudget.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest){

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(),ex.getMessage(),webRequest.getDescription(false));

       return  new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IncomeNotFoundException.class)
    public final ResponseEntity<Object> handleIncomeNotFoundException(IncomeNotFoundException ex, WebRequest webRequest){

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(),ex.getMessage(),webRequest.getDescription(false));

        return  new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExpenditureNotFoundException.class)
    public final ResponseEntity<Object> handleExpenditureNotFoundException(ExpenditureNotFoundException ex, WebRequest webRequest){

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(),ex.getMessage(),webRequest.getDescription(false));

        return  new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {

        ExceptionResponse exceptionResponse =
                new ExceptionResponse(new Date(),"Validation Failed",ex.getBindingResult().toString());

        return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
    }


}
