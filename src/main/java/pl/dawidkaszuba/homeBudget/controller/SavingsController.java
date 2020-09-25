package pl.dawidkaszuba.homeBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.homeBudget.entity.Savings;
import pl.dawidkaszuba.homeBudget.exception.UserNotFoundException;
import pl.dawidkaszuba.homeBudget.service.SavingsService;
import pl.dawidkaszuba.homeBudget.service.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SavingsController {

    private final SavingsService savingsService;
    private final UserService userService;

    @Autowired
    public SavingsController(SavingsService savingsService, UserService userService) {
        this.savingsService = savingsService;
        this.userService = userService;
    }

    @GetMapping("/users/{userId}/savings")
    public Savings getCurrentSavings(@PathVariable String userId,
                                     HttpServletRequest request) {
        if(userService.isCorrectUser(userId, request)){
            return this.savingsService.getSavings(userId);
        }
        else throw new UserNotFoundException("userId from PathVariable do not match to current token");
    }

    @PostMapping("/users/{userId}/savings")
    public Savings updateSavings(@PathVariable String userId,
                                 @RequestBody Savings savings,
                                 HttpServletRequest request) {
        if(userService.isCorrectUser(userId, request)){
            return this.savingsService.updateSavings(userId, savings);
        }
        else throw new UserNotFoundException("userId from PathVariable do not match to current token");
    }

}


