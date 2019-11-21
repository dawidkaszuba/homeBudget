package pl.dawidkaszuba.homeBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.dawidkaszuba.homeBudget.entity.Expenditure;
import pl.dawidkaszuba.homeBudget.service.ExpenditureService;

import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
public class ExpenditureController {


    private final ExpenditureService expenditureService;

    @Autowired
    public ExpenditureController(ExpenditureService expenditureService) {
        this.expenditureService = expenditureService;
    }


    @GetMapping("/expenditures")
    public List<Expenditure> findAll(){
        return expenditureService.findAll();
    }

    @GetMapping("/expenditures/{from}/{to}")
    public List<Expenditure> findAllFromTo(@PathVariable String from, @PathVariable String to){
        return expenditureService.findAllFromTo(from,to);
    }

    @GetMapping("/expenditures/month/{month}")
    public List<Expenditure> findAllForMonth(@PathVariable String month){
        return expenditureService.findByMonth(month);
    }

    @GetMapping("/expenditures/tag/{tag}")
    public List<Expenditure> findAllByTag(@PathVariable String tag){
        return expenditureService.findAllByTag(tag);
    }

    @GetMapping("/expenditures/month/{month}/tag/{tag}")
    public List<Expenditure> findAllForMonthByTag(@PathVariable String month, @PathVariable String tag){
        return expenditureService.findAllForMonthByTag(month,tag);
    }

    @GetMapping("/expenditures/{id}")
    public Optional<Expenditure> findById(@PathVariable Long id){
        return expenditureService.findById(id);
    }

    @DeleteMapping("/expenditures/{id}")
    public void deleteById(@PathVariable Long id){
        expenditureService.deleteById(id);
    }

    @PutMapping("/expenditures")
    public void edit(@RequestBody Expenditure expenditure){
        expenditureService.save(expenditure);
    }

    @PostMapping("/expenditures")
    public void save(@RequestBody Expenditure expenditure){
        expenditureService.save(expenditure);
    }


}
