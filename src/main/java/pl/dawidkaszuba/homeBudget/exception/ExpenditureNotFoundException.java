package pl.dawidkaszuba.homeBudget.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExpenditureNotFoundException extends RuntimeException {

    public ExpenditureNotFoundException(String message) {
        super(message);
    }
}
