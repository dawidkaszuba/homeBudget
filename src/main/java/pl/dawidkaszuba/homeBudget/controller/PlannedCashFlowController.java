package pl.dawidkaszuba.homeBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.dawidkaszuba.homeBudget.entity.PlannedCashFlow;
import pl.dawidkaszuba.homeBudget.entity.User;
import pl.dawidkaszuba.homeBudget.exception.PlannedCashFlowNotFoundException;
import pl.dawidkaszuba.homeBudget.exception.UserNotFoundException;
import pl.dawidkaszuba.homeBudget.service.PlannedCashFlowService;
import pl.dawidkaszuba.homeBudget.service.UserService;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class PlannedCashFlowController {

    private final PlannedCashFlowService plannedCashFlowService;
    private final UserService userService;

    @Autowired
    public PlannedCashFlowController(PlannedCashFlowService plannedCashFlowService, UserService userService) {
        this.plannedCashFlowService = plannedCashFlowService;
        this.userService = userService;
    }



    @GetMapping("/users/{userId}/plannedCashFlows")
    public List<PlannedCashFlow> findAllByUser(@PathVariable Long userId,
                                               @RequestParam(required = false) String startDate,
                                               @RequestParam(required = false) String endDate){

        Optional<User> optionalUser = userService.findById(userId);

        if(!optionalUser.isPresent()) {

            throw new UserNotFoundException("id-" + userId);

        }else{

            if(startDate == null || endDate == null){

                return plannedCashFlowService.findAllByUserId(userId);

            }else {

                LocalDate startDateLocalDate = LocalDate.parse(startDate);
                LocalDate endDateLocalDate = LocalDate.parse(endDate);

                return plannedCashFlowService
                        .findAllByUserIdAndStartDateGreaterThanAndEndDateLessThan(userId,
                                                                                  startDateLocalDate,
                                                                                  endDateLocalDate);
            }

        }
    }

    @GetMapping("/users/{userId}/plannedCashFlows/{plannedCashFlowId}")
    public Optional<PlannedCashFlow> findByUserIdAndId(@PathVariable Long userId,
                                                       @PathVariable Long plannedCashFlowId) {

        Optional<User> optionalUser = userService.findById(userId);

        if(!optionalUser.isPresent()) {

            throw new UserNotFoundException("id-" + userId);

        }else {

            Optional<PlannedCashFlow> optionalPlannedCashFlow = plannedCashFlowService.findById(plannedCashFlowId);

            if(!optionalPlannedCashFlow.isPresent()) {

                throw new PlannedCashFlowNotFoundException("id-" + plannedCashFlowId);

            }else {

                if(optionalPlannedCashFlow.get().getUser().getId().equals(optionalUser.get().getId())){

                    return plannedCashFlowService.findById(plannedCashFlowId);

                }else{

                    throw new PlannedCashFlowNotFoundException("No plannedCashFlow with id-" + plannedCashFlowId +
                            " for user with id-" + userId);
                }

            }
        }

    }


    @PostMapping("/users/{userId}/plannedCashFlows")
    public ResponseEntity<Object> save(@RequestBody PlannedCashFlow plannedCashFlow,
                                       @PathVariable Long userId){

        Optional<User> optionalUser = userService.findById(userId);

        if(!optionalUser.isPresent()) {

            throw new UserNotFoundException("id-" + userId);

        }else{


            plannedCashFlowService.save(plannedCashFlow);

        }

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(plannedCashFlowService.save(plannedCashFlow).getId()).toUri();

        return ResponseEntity.created(location).build();


    }

    @PutMapping("/users/{userId}/plannedCashFlows")
    public void edit(@RequestBody PlannedCashFlow plannedCashFlows,
                     @PathVariable Long userId){

        Optional<User> optionalUser = userService.findById(userId);

        if (!optionalUser.isPresent()) {

            throw new UserNotFoundException("id-" + userId);

        }else {

            plannedCashFlowService.save(plannedCashFlows);
        }

    }

    @DeleteMapping("/users/{userId}/plannedCashFlows/{plannedCashFlowId}")
    public void deleteById(@PathVariable Long plannedCashFlowId,
                           @PathVariable Long userId){

        Optional<User> optionalUser = userService.findById(userId);

        if (!optionalUser.isPresent()) {

            throw new UserNotFoundException("id-"+ userId);

        }else {

            Optional<PlannedCashFlow> plannedCashFlow = plannedCashFlowService.findById(plannedCashFlowId);

            if (!plannedCashFlow.isPresent()) {

                throw new PlannedCashFlowNotFoundException("id-" + plannedCashFlowId);

            }else {

                if(optionalUser.get().getId().equals(plannedCashFlow.get().getUser().getId())) {

                    plannedCashFlowService.deleteById(plannedCashFlowId);

                }else {

                    throw new PlannedCashFlowNotFoundException("No tag with id-" + plannedCashFlowId +
                            " for user with id-" + userId);
                }
            }
        }
    }
}
