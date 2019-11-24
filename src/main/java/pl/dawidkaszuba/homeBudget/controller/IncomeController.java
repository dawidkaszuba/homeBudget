package pl.dawidkaszuba.homeBudget.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.homeBudget.entity.Income;
import pl.dawidkaszuba.homeBudget.service.IncomeService;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
public class IncomeController {

    private final IncomeService incomeService;

    @Autowired
    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }


    @GetMapping("/incomes")
    public List<Income> findAll(@RequestParam(required = false) String from, @RequestParam(required = false) String to){
        if(from == null || to == null) {

            return incomeService.findAll();

        } else {

            return incomeService.findAllFromTo(from,to);

        }
    }


    @GetMapping("/incomes/{id}")
    public Optional<Income> findById(@PathVariable Long id){
        return incomeService.findById(id);
    }

    @DeleteMapping("/incomes/{id}")
    public void deleteById(@PathVariable Long id){
        incomeService.deleteById(id);
    }

    @PutMapping("/incomes")
    public void edit(@RequestBody Income income){
        incomeService.save(income);
    }

    @PostMapping("/incomes")
    public void save(@RequestBody Income income){
        incomeService.save(income);
    }
}
