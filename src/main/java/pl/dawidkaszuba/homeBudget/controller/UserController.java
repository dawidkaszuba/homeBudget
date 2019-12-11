package pl.dawidkaszuba.homeBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.dawidkaszuba.homeBudget.entity.User;
import pl.dawidkaszuba.homeBudget.exception.UserNotFoundException;
import pl.dawidkaszuba.homeBudget.service.UserService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public List<User> findAll(){

        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> findById(@PathVariable Long id){

        Optional<User> optionalUser = userService.findById(id);

        if(!optionalUser.isPresent()){

            throw new UserNotFoundException("id-" + id);
        }

        return userService.findById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> save(@RequestBody User user){

        userService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userService.save(user).getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}
