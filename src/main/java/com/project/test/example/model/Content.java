package com.project.test.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
@Table(name = "content")
public class Content {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        Integer id;
        @NotBlank
        @Column(name = "title")
        String title;
//        @NotBlank
//        @Column(name = "desc")
//        String desc;

        @Column(name = "status")
        Status status;

        @Column(name = "type")
        Type type;

        @Column(name = "dateCreated")
        LocalDateTime dateCreated;

        @Column(name = "dateUpdated")
        LocalDateTime dateUpdated;

        @Column(name = "url")
        String url;

        public Content(){}
        public Content(Integer id, String title, String desc, Status status, Type type, LocalDateTime dateCreated, LocalDateTime dateUpdated, String url) {
                this.id = id;
                this.title = title;
//                this.desc = desc;
                this.status = status;
                this.type = type;
                this.dateCreated = dateCreated;
                this.dateUpdated = dateUpdated;
                this.url = url;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

//        public String getDesc() {
//                return desc;
//        }
//
//        public void setDesc(String desc) {
//                this.desc = desc;
//        }

        public Status getStatus() {
                return status;
        }

        public void setStatus(Status status) {
                this.status = status;
        }

        public Type getType() {
                return type;
        }

        public void setType(Type type) {
                this.type = type;
        }

        public LocalDateTime getDateCreated() {
                return dateCreated;
        }

        public void setDateCreated(LocalDateTime dateCreated) {
                this.dateCreated = dateCreated;
        }

        public LocalDateTime getDateUpdated() {
                return dateUpdated;
        }

        public void setDateUpdated(LocalDateTime dateUpdated) {
                this.dateUpdated = dateUpdated;
        }

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }
}
