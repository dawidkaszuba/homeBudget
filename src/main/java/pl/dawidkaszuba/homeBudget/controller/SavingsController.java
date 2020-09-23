package pl.dawidkaszuba.homeBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.dawidkaszuba.homeBudget.service.SavingsService;

@RestController
public class SavingsController {

    private final SavingsService savingsService;

    @Autowired
    public SavingsController(SavingsService savingsService) {
        this.savingsService = savingsService;
    }
}
