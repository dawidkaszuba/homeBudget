package pl.dawidkaszuba.homeBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.dawidkaszuba.homeBudget.app.configuration.JwtTokenUtil;
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
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public BalanceController(BalanceService balanceService, UserService userService, JwtTokenUtil jwtTokenUtil) {
        this.balanceService = balanceService;
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
    }





    @GetMapping("/users/{userId}/balance")
    public Balance getBalance(@PathVariable String userId, @RequestParam String from, @RequestParam String to, HttpServletRequest request) {

        System.out.println(userService.findByUserName(jwtTokenUtil.getUsernameFromToken(request.getHeader("authorization").substring(7))).getId());

       if(isCorrectUser(userId, request)){

            return balanceService.getBalance(userId,from,to);
        }

        else throw new UserNotFoundException("Invalid user");
    }

    private boolean isCorrectUser(@PathVariable String userId, HttpServletRequest request) {
        return userService.findByUserName(jwtTokenUtil.getUsernameFromToken(request.getHeader("authorization").substring(7))).getId().toString().equals(userId);
    }
}
