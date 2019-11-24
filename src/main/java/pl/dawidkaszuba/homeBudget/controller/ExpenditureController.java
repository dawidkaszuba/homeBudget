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
    public List<Expenditure> findAll(@RequestParam(required = false) String from, @RequestParam(required = false) String to){
        if(from == null || to == null) {

            return expenditureService.findAll();

        } else {

            return expenditureService.findAllFromTo(from,to);

        }
    }

    @GetMapping("/expenditures/tag/{tag}")
    public List<Expenditure> findAllByTagFromTo(@RequestParam(required = false) String from,
                                                @RequestParam(required = false) String to,
                                                @PathVariable(required = false) String tag){

        if(from == null || to == null){

            return expenditureService.findAllByTag(tag);

        }else{

            return expenditureService.findAllByTagFromTo(from,to,tag);
        }
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
