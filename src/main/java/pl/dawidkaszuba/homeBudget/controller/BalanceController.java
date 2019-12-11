package pl.dawidkaszuba.homeBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.dawidkaszuba.homeBudget.model.Balance;
import pl.dawidkaszuba.homeBudget.service.BalanceService;

@Controller
@ResponseBody
public class BalanceController {


    private final BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @GetMapping("/users/{userId}/balance")
    public Balance getBalance(@PathVariable String userId, @RequestParam String from, @RequestParam String to){
        return balanceService.getBalance(userId,from,to);
    }
}
