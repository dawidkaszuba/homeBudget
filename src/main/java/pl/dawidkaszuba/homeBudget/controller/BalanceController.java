package pl.dawidkaszuba.homeBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.dawidkaszuba.homeBudget.exception.UserNotFoundException;
import pl.dawidkaszuba.homeBudget.model.Balance;
import pl.dawidkaszuba.homeBudget.service.BalanceService;
import pl.dawidkaszuba.homeBudget.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
public class BalanceController {


    private final BalanceService balanceService;
    private final UserService userService;

    @Autowired
    public BalanceController(BalanceService balanceService, UserService userService) {
        this.balanceService = balanceService;
        this.userService = userService;
    }


    @GetMapping("/users/{userId}/balance")
    public Balance getBalance(@PathVariable String userId,
                              @RequestParam String from,
                              @RequestParam String to,
                              HttpServletRequest request) {


       if(userService.isCorrectUser(userId, request)){

            return balanceService.getBalance(userId,from,to);
        }

        else throw new UserNotFoundException("userId from PathVariable do not match to current token");
    }


}
