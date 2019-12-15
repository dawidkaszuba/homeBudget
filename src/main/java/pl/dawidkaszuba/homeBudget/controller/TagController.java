package pl.dawidkaszuba.homeBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.dawidkaszuba.homeBudget.entity.Tag;
import pl.dawidkaszuba.homeBudget.entity.User;
import pl.dawidkaszuba.homeBudget.exception.TagNotFoundException;
import pl.dawidkaszuba.homeBudget.exception.UserNotFoundException;
import pl.dawidkaszuba.homeBudget.service.TagService;
import pl.dawidkaszuba.homeBudget.service.UserService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
public class TagController {

    private final TagService tagService;
    private final UserService userService;

    @Autowired
    public TagController(TagService tagService,UserService userService) {
        this.tagService = tagService;
        this.userService = userService;
    }

    @GetMapping("/users/{userId}/tags")
    public List<Tag> findAll(@PathVariable Long userId){

        Optional<User> optionalUser = userService.findById(userId);

        if (!optionalUser.isPresent()) {

            throw new UserNotFoundException("id-" + userId);

        }else{

            return tagService.findAllByUserId(userId);
        }
    }

    @GetMapping("/users/{userId}/tags/{tagId}")
    public Optional<Tag> findById(@PathVariable Long tagId,
                                  @PathVariable Long userId) {

        Optional<User> optionalUser = userService.findById(userId);

        if (!optionalUser.isPresent()) {

            throw new UserNotFoundException("id-" + userId);
        }else{

            Optional<Tag> optionalTag = tagService.findbyId(tagId);

            if(!optionalTag.isPresent()) {

                throw new TagNotFoundException("id-" + tagId);
            }else{

                if(optionalTag.get().getUser().getId().equals(optionalUser.get().getId())){

                    return tagService.findbyId(tagId);
                }else {

                    throw new TagNotFoundException("No tag with id-" + tagId +
                            " for user with id-" + userId);
                }
            }
        }
    }

    @DeleteMapping("/tags/{id}")
    public void deleteById(@PathVariable Long id){
        tagService.deleteById(id);
    }

    @PutMapping("/tags")
    public void edit(@RequestBody Tag tag){
        tagService.save(tag);
    }

    @PostMapping("/tags")
    public ResponseEntity<Object> save(@RequestBody Tag tag) {

        tagService.save(tag);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tagService.save(tag).getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
