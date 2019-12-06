package com.wiley.ranku.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppPage {

    @JsonProperty("url")
    private String url;

    @JsonProperty("elements")
    private ArrayList<Element> elements;

    public ArrayList<Element> getElements() {
        return elements;
    }

    public String getXpath(String name){
        String xpath = null;
        for (int i=0;i<elements.size();i++){
            if (elements.get(i).getName().equals(name)){
                xpath =  elements.get(i).getXpath();
                break;
            }
        }
        return xpath;
    }
//    public String getData(String name) {
//        String data = null;
//        for (int i=0;i<elements.size();i++){
//            if (elements.get(i).getName().equals(name)){
//                data =  elements.get(i).getData();
//                break;
//            }
//        }
//        return data;
//    }
    public String getfontsize(String name) {
        String data = null;
        for (int i=0;i<elements.size();i++){
            if (elements.get(i).getName().equals(name)){
                data =  elements.get(i).getfontsize();
                break;
            }
        }
        return data;
    }
    public String getfontfamily(String name) {
        String data = null;
        for (int i=0;i<elements.size();i++){
            if (elements.get(i).getName().equals(name)){
                data =  elements.get(i).getfontfamily();
                break;
            }
        }
        return data;
    }

    public String getfontcolor(String name) {
        String data = null;
        for (int i=0;i<elements.size();i++){
            if (elements.get(i).getName().equals(name)){
                data =  elements.get(i).getfontcolor();
                break;
            }
        }
        return data;
    }

    public String getFields(String name) {
        String data = null;
        for (int i=0;i<elements.size();i++){
            if (elements.get(i).getName().equals(name)){
                data =  elements.get(i).getField();
                break;
            }
        }
        return data;
    }

}
