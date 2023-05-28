package com.project.test.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Type {

    ARTICLE,
    VIDEO,
    COURSE,
    CONFERENCE_TALK;

    @JsonCreator
    public static Type fromString(String type) {
        if(type.equalsIgnoreCase("")) {
            return null;
        }
        return Type.valueOf(type);
    }
}
