package com.wiley.ranku.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class TestDataSet {
    @JsonProperty("testcaseID")
    private String testcaseID;

    @JsonProperty("degreeLevel")
    private String degreeLevel;

    @JsonProperty("fieldOfStudy")
    private String fieldOfStudy;

    @JsonProperty("intrestProgram")
    private String intrestProgram;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("emailAdress")
    private String emailAdress;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("country")
    private String country;

    @JsonProperty("zipcode")
    private String zipcode;

    @JsonProperty("levelOfEducation")
    private String levelOfEducation;

    @JsonProperty("pursuingDegree")
    private String pursuingDegree;

    @JsonProperty("question")
    private String question;

    @JsonProperty("contactCheckBox")
    private String contactCheckBox;

    @JsonProperty("SearchText")
    private String searchText;

    public String getTestcaseID(){
        return testcaseID;
    }

    public String getDegreeLevel() {
        return degreeLevel;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }
    public String getIntrestProgram() {
        return intrestProgram;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getEmailAdress() {
        return emailAdress;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getPursuingDegree() {
        return pursuingDegree;
    }

    public String getQuestion() {
        return question;
    }

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public String getContactCheckBox() {
        return contactCheckBox;
    }
    public String getSearchText() {
        return searchText;
    }

}
