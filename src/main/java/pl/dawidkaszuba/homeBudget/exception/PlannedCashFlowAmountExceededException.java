package pl.dawidkaszuba.homeBudget.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlannedCashFlowAmountExceededException extends RuntimeException{
    public PlannedCashFlowAmountExceededException(String message) {
        super(message);
    }
}
