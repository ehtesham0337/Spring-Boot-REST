package com.project.test.example.repository;

import com.project.test.example.model.Content;
import com.project.test.example.model.Status;
import com.project.test.example.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {  // Optional -> may or may not be null
        return contentList.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.removeIf(c -> c.getId().equals(content.getId())); // remove data on the Id
        contentList.add(content); // replace with updated data on the same Id
    }

//    public void updateById(Integer id, Content content) {
//        contentList.set(id - 1, content);
//    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.getId().equals(id)).count() == 1; // does id exist?
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.getId().equals(id));
    }

    @PostConstruct // initialize dependency injection
    private void init() {
        Content c = new Content(
                1,
                "My First Blog Post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                ""
        );

        contentList.add(c);
    }


}
