package com.project.test.example.service;

import com.project.test.example.model.Content;
import com.project.test.example.repository.ContentJPARespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {
    @Autowired
    private ContentJPARespository repo;

    public Content saveContent(Content con){
        return repo.save(con);
    }

    public List<Content> getContent(){
        return repo.findAll();
    }


}
