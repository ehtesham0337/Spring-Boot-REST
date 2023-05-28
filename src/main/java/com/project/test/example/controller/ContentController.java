package com.project.test.example.controller;

import com.project.test.example.model.Content;
import com.project.test.example.repository.ContentCollectionRepository;
import com.project.test.example.repository.ContentJPARespository;
import com.project.test.example.service.ContentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/content") // url to access apis
@CrossOrigin(origins = "http://localhost:8080")
@Tag(name = "Content") // swagger controller name
public class ContentController {
//    private final ContentCollectionRepository repository; //dependency injection of ContentCollectionRepository
//    public ContentController(ContentCollectionRepository repository) { // constructor
//        this.repository = repository;
//    }

    @Autowired
    private ContentJPARespository jpaRespository;

//    // get all content
//    @GetMapping("/getAll")
//    public List<Content> finAll() {
//        return repository.findAll();
//    }

    // get all content
    @GetMapping("/getAll")
    public List<Content> findAll() {
        return jpaRespository.findAll();
    }

//    // get content by id
//    @GetMapping("/getById/{id}")
//    public Content findById(@PathVariable Integer id) { // @PathVariable is like useParams() in react
//        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found"));
//    }

//    // create new content
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/create")
//    public void create(@Valid @RequestBody Content content) {
//        repository.save(content);
//    }

    // create new content

    @PostMapping("/create")
    public Content saveCon(@RequestBody Content content) {
        return jpaRespository.save(content);
    }


//    // update content by id
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping("/update/{id}")
//    public void update(@PathVariable Integer id, @RequestBody Content content) {
//        if (!repository.existsById(id)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id must be greater than 0");
//        }
//        repository.save(content);
////        repository.updateById(id, content);
//
//    }
//
//    // delete content by id
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable Integer id) {
//        if (!repository.existsById(id)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id must be greater than 0");
//        }
//        repository.delete(id);
//    }

}
