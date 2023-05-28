package com.project.test.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;


public enum Status {
    IDEA,
    IN_PROGRESS,
    COMPLETED,
    PUBLISHED;

    @JsonCreator
    public static Status fromString(String status) {
        if(status.equalsIgnoreCase("")) {
            return null;
        }
        return Status.valueOf(status);
    }

}



