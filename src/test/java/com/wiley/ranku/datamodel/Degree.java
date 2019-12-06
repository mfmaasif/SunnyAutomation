package com.wiley.ranku.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Degree {

    @JsonProperty("level")
    private String level;

    @JsonProperty("subjects")
    private ArrayList<String> subjects;

    public String getLevel() {
        return level;
    }
    public ArrayList<String> getSubject() {
        return subjects;
    }
}
