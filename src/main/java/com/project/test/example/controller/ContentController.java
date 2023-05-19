package com.project.test.example.controller;

import com.project.test.example.model.Content;
import com.project.test.example.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content") // url to access apis
public class ContentController {
    private final ContentCollectionRepository repository; //dependency injection of ContentCollectionRepository

    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    } // constructor

    // findAll content
    @GetMapping("")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) { // @PathVariable is like useParams() in react
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void create(@RequestBody Content content) {
        repository.save(content);
    }
}
