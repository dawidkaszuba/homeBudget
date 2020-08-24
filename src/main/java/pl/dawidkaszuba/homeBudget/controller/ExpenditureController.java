package pl.dawidkaszuba.homeBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.dawidkaszuba.homeBudget.entity.Expenditure;
import pl.dawidkaszuba.homeBudget.entity.PlannedCashFlow;
import pl.dawidkaszuba.homeBudget.entity.User;
import pl.dawidkaszuba.homeBudget.exception.ExpenditureNotFoundException;
import pl.dawidkaszuba.homeBudget.exception.PlannedCashFlowAmountExceededException;
import pl.dawidkaszuba.homeBudget.exception.UserNotFoundException;
import pl.dawidkaszuba.homeBudget.service.ExpenditureService;
import pl.dawidkaszuba.homeBudget.service.PlannedCashFlowService;
import pl.dawidkaszuba.homeBudget.service.UserService;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
public class ExpenditureController {


    private final ExpenditureService expenditureService;
    private final UserService userService;
    private final PlannedCashFlowService plannedCashFlowService;

    @Autowired
    public ExpenditureController(ExpenditureService expenditureService,
                                 UserService userService, PlannedCashFlowService plannedCashFlowService) {
        this.expenditureService = expenditureService;
        this.userService=userService;
        this.plannedCashFlowService = plannedCashFlowService;
    }

    @GetMapping("/users/{userId}/expenditures")
    public List<Expenditure> findAll(@RequestParam(required = false) String from,
                                     @RequestParam(required = false) String to,
                                     @PathVariable Long userId){

        Optional<User> optionalUser = userService.findById(userId);

        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("id-"+userId);
        }else{
            if(from == null || to == null) {
                return expenditureService.findAllByUserId(userId);
            }else {
                LocalDate localDateFrom = LocalDate.parse(from);
                LocalDate localDateTo = LocalDate.parse(to);
                return expenditureService.findAllByUserIdAndExpenditureDateBetween(userId,localDateFrom,localDateTo);
            }
        }
    }

    @GetMapping("/users/{userId}/expenditures/tags/{tagId}")
    public List<Expenditure> findAllByTagFromTo(@RequestParam(required = false) String from,
                                                @RequestParam(required = false) String to,
                                                @PathVariable String tagId,
                                                @PathVariable String userId){

        if(from == null || to == null){
            return expenditureService.findAllByTag(userId,tagId);
        }else {
            return expenditureService.findAllByTagFromTo(userId,from,to,tagId);
        }
    }

    @GetMapping("/users/{userId}/expenditures/{expenditureId}")
    public Optional<Expenditure> findById(@PathVariable Long expenditureId,
                                          @PathVariable Long userId) {

        Optional<User> optionalUser = userService.findById(userId);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("id-" + userId);
        }else {
            Optional<Expenditure> optionalExpenditure = expenditureService.findById(expenditureId);
            if (!optionalExpenditure.isPresent()) {
                throw new ExpenditureNotFoundException("id-" + expenditureId);
            }else {
                if (optionalExpenditure.get().getUser().getId().equals(optionalUser.get().getId())) {
                    return expenditureService.findById(expenditureId);
                }else {
                    throw new ExpenditureNotFoundException("No expenditure with id-" + expenditureId +
                            " for user with id-" + userId);
                }
            }
        }
    }

    @DeleteMapping("/users/{userId}/expenditures/{expenditureId}")
    public void deleteById(@PathVariable Long expenditureId,
                           @PathVariable Long userId){

        Optional<User> optionalUser = userService.findById(userId);
        if(!optionalUser.isPresent()) {
            throw new UserNotFoundException("id-" + userId);
        }else {
            Optional<Expenditure> optionalExpenditure = expenditureService.findById(expenditureId);
            if(!optionalExpenditure.isPresent()){
                throw new ExpenditureNotFoundException("id-" + expenditureId);
            }else {
                if(optionalExpenditure.get().getUser().getId().equals(optionalUser.get().getId())) {
                    expenditureService.deleteById(optionalExpenditure.get().getId());
                }else {
                    throw new ExpenditureNotFoundException("No expenditures with id-" + expenditureId +
                            " for user with id-" + userId);
                }
            }
        }
    }

    @PutMapping("/users/{userId}/expenditures")
    public void edit(@RequestBody Expenditure expenditure,
                     @PathVariable Long userId){

        Optional<User> optionalUser = userService.findById(userId);
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("id-"+userId);
        }else{
            expenditureService.save(expenditure);
        }
    }

    @PostMapping("/users/{userId}/expenditures")
    public ResponseEntity<Object> save(@Valid @RequestBody Expenditure expenditure,
                                       @PathVariable Long userId){

        Optional<User> optionalUser = userService.findById(userId);
        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("id-" + userId);
        }else {
            expenditure.setUser(optionalUser.get());
        }
        Optional optionalPlannedCashFlow = plannedCashFlowService.findById(expenditure.getPlannedCashFlow().getId());
        if(optionalPlannedCashFlow.isPresent()) {
            PlannedCashFlow pcf = (PlannedCashFlow) optionalPlannedCashFlow.get();
            if(expenditure.getAmount().compareTo(pcf.getPlannedAmount().subtract(pcf.getCurrentSumAmount())) > 0){
                throw new PlannedCashFlowAmountExceededException("Expenditure amount is to high. Plan higher planned cash flow amount");
            } else {
                BigDecimal newPcfAmount = pcf.getCurrentSumAmount().add(expenditure.getAmount());
                pcf.setCurrentSumAmount(newPcfAmount);
                plannedCashFlowService.save(pcf);
            }
        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(expenditureService.save(expenditure).getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
