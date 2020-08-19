package pl.dawidkaszuba.homeBudget.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlannedCashFlowNotFoundException extends RuntimeException {
    public PlannedCashFlowNotFoundException(String message) {
        super(message);
    }
}
