package pl.dawidkaszuba.homeBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.dawidkaszuba.homeBudget.entity.Expenditure;
import pl.dawidkaszuba.homeBudget.service.ExpenditureService;

import javax.validation.Valid;
import java.net.URI;
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

    @GetMapping("/users/{userId}/expenditures")
    public List<Expenditure> findAll(@RequestParam(required = false) String from,
                                     @RequestParam(required = false) String to,
                                     @PathVariable String userId){
        if(from == null || to == null) {

            return expenditureService.findAll();

        } else {

            return expenditureService.findAllFromTo(userId,from,to);

        }
    }

    @GetMapping("/users/{userId}/expenditures/tags/{tagId}")
    public List<Expenditure> findAllByTagFromTo(@RequestParam(required = false) String from,
                                                @RequestParam(required = false) String to,
                                                @PathVariable String tagId,
                                                @PathVariable String userId){

        if(from == null || to == null){

            return expenditureService.findAllByTagFromTo(userId,from,to,tagId);

        }else{

            return expenditureService.findAllByTag(userId,tagId);
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
    public ResponseEntity<Object> save(@Valid @RequestBody Expenditure expenditure){

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(expenditureService.save(expenditure).getId()).toUri();

        return ResponseEntity.created(location).build();
    }


}
