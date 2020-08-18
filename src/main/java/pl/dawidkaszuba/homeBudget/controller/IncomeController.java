package pl.dawidkaszuba.homeBudget.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.dawidkaszuba.homeBudget.entity.Income;
import pl.dawidkaszuba.homeBudget.entity.User;
import pl.dawidkaszuba.homeBudget.exception.IncomeNotFoundException;
import pl.dawidkaszuba.homeBudget.exception.UserNotFoundException;
import pl.dawidkaszuba.homeBudget.service.IncomeService;
import pl.dawidkaszuba.homeBudget.service.UserService;

import javax.validation.Valid;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
public class IncomeController {

    private final IncomeService incomeService;
    private final UserService userService;

    @Autowired
    public IncomeController(IncomeService incomeService, UserService userService) {
        this.incomeService = incomeService;
        this.userService=userService;
    }


    @GetMapping("/users/{userId}/incomes")
    public List<Income> findAll(@RequestParam(required = false) String from,
                                @RequestParam(required = false) String to,
                                @PathVariable Long userId){

        Optional<User> optionalUser = userService.findById(userId);
        if (!optionalUser.isPresent()) {
            throw  new UserNotFoundException("id-"+userId);
        }else{
            if (from == null || to == null) {
                return incomeService.findAllByUserId(userId);
            }else {
                LocalDate localDateFrom = LocalDate.parse(from);
                LocalDate localDateTo = LocalDate.parse(to);
                return incomeService.findAllByUserIdAndIncomeDateBetween(userId,localDateFrom, localDateTo);
            }
        }
    }

    @GetMapping("/users/{userId}/incomes/{incomeId}")
    public Optional<Income> findById(@PathVariable Long incomeId,
                                     @PathVariable Long userId){

        Optional<User> optionalUser = userService.findById(userId);
        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException("id-"+userId);
        }else {
            Optional<Income> optionalIncome = incomeService.findById(incomeId);
            if(!optionalIncome.isPresent()){
                throw new IncomeNotFoundException("id-"+ incomeId);
            }else{
                if(optionalIncome.get().getUser().getId().equals(optionalUser.get().getId())){
                    return incomeService.findById(incomeId);
                }else {
                    throw new IncomeNotFoundException("No income with id-" + incomeId +
                            " for user with id-" + userId);
                }
            }
        }
    }

    @DeleteMapping("/users/{userId}/incomes/{incomeId}")
    public void deleteById(@PathVariable Long incomeId,
                           @PathVariable Long userId){

        Optional<User> optionalUser = userService.findById(userId);

        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException("id-" + userId);
        }else {
            Optional<Income> optionalIncome = incomeService.findById(incomeId);
            if (!optionalIncome.isPresent()) {
                throw new IncomeNotFoundException("id-" + incomeId);
            }else {
                if(optionalIncome.get().getUser().getId().equals(optionalUser.get().getId())) {
                    incomeService.deleteById(incomeId);
                }else {
                    throw new IncomeNotFoundException("No income with id-" + incomeId +
                            " for user with id-" + userId);
                }
            }
        }
    }

    @PutMapping("/users/{userId}/incomes")
    public void edit(@RequestBody Income income,
                     @PathVariable Long userId){

        Optional<User> optionalUser = userService.findById(userId);
        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException("id-" + userId);
        }else {
            incomeService.save(income);
        }
    }

    @PostMapping("/users/{userId}/incomes")
    public ResponseEntity<Object> save(@Valid @RequestBody Income income,
                                       @PathVariable Long userId){

        Optional<User> optionalUser = userService.findById(userId);

        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("id-" + userId);
        }else {
            income.setUser(optionalUser.get());
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(incomeService.save(income).getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
