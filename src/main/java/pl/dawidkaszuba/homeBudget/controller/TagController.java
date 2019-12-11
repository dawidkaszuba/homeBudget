package pl.dawidkaszuba.homeBudget.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.dawidkaszuba.homeBudget.entity.Tag;
import pl.dawidkaszuba.homeBudget.exception.TagNotFoundException;
import pl.dawidkaszuba.homeBudget.service.TagService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/tags")
    public List<Tag> findAll(){
        return tagService.findall();
    }

    @GetMapping("/tags/{id}")
    public Optional<Tag> findById(@PathVariable Long id) {

        Optional<Tag> optionalTag = tagService.findbyId(id);

        if(!optionalTag.isPresent()) {
            throw new TagNotFoundException("id-" + id);
        }

        return tagService.findbyId(id);
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
