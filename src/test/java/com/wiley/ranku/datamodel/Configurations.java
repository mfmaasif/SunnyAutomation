package com.wiley.ranku.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Configurations {

    @JsonProperty("degrees")
    private ArrayList<Degree> degrees;

    @JsonProperty("institutions")
    private ArrayList<String> institutions;



    public ArrayList<String> getInstitutions() {
        return institutions;
    }

    public ArrayList<Degree> getDegrees() {
        return degrees;
    }
}
