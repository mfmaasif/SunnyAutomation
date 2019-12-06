package com.wiley.ranku.datamodel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Element {

    @JsonProperty("name")
    private String name;

    @JsonProperty("label")
    private String label;

    @JsonProperty("required")
    private boolean isRequired;

    @JsonProperty("xpath")
    private String xpath;

    @JsonProperty("data")
    private String data;

    @JsonProperty("values")
    private String[] values;

    @JsonProperty("fontsize")
    private String fontsize;

    @JsonProperty("fontcolor")
    private String fontcolor;

    @JsonProperty("fontfamily")
    private String fontfamily;

    @JsonProperty("webelement")
    private String element;

    @JsonProperty("type")
    private String type;


    public String getName() {
        return name;
    }
    public String getLabel() {
        return label;
    }
    public boolean isRequired() {
        return isRequired;
    }
    public String getXpath() {
        return xpath;
    }
    public String getData() {
        return data;
    }
    public String getfontcolor(){
        return fontcolor;
    }
    public String getfontsize(){
        return fontsize;
    }
    public String getfontfamily(){
        return fontfamily;
    }
    public String getField(){
        return element;
    }

    public String getType(){
        return type;
    }
}
