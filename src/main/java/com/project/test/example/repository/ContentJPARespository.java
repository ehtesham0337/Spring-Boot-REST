package com.project.test.example.repository;

import com.project.test.example.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentJPARespository extends JpaRepository<Content, Integer> {

}
