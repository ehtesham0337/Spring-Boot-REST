package com.project.test.example.controller;

import com.project.test.example.model.Content;
import com.project.test.example.repository.ContentCollectionRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content") // url to access apis
@Tag(name = "Content")
public class ContentController {
    private final ContentCollectionRepository repository; //dependency injection of ContentCollectionRepository

    public ContentController(ContentCollectionRepository repository) { // constructor
        this.repository = repository;
    }

    // get all content
    @GetMapping("/getAll")
    public List<Content> findAll() {
        return repository.findAll();
    }

    // get content by id
    @GetMapping("/getById/{id}")
    public Content findById(@PathVariable Integer id) { // @PathVariable is like useParams() in react
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    // create new content
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void create(@RequestBody Content content) {
        repository.save(content);
    }

    // update content by id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    public void update(@PathVariable Integer id, @RequestBody Content content) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id must be greater than 0");
        }
        repository.save(content);
//        repository.updateById(id, content);

    }

    // delete content by id
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id must be greater than 0");
        }
        repository.delete(id);
    }

}
