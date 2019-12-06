package com.wiley.ranku.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TestData {

    @JsonProperty("TestDataSets")
    private ArrayList<HashMap<String,String>>  dataSets;


    public HashMap<String,String> getDataSetById(String id){

        HashMap<String,String> dataSet= null;
        ArrayList<HashMap<String,String>> data = new ArrayList<HashMap<String,String>>();
        for (HashMap<String,String> ds: dataSets){
            if (ds.get("testcaseID").equalsIgnoreCase(id)) {
                dataSet =  ds;
                break;
            }
        }
        return dataSet;
    }



//    @JsonProperty("TestDataSets")
//    private ArrayList<TestDataSet> testDataSets;
//
//    public ArrayList<TestDataSet> getTestdataset(){
//        return testDataSets;
//    }
//
//    public TestDataSet getTestdataset(String testcaseID){
//
//        TestDataSet testdataset = null;
//        for (int i=0;i<testDataSets.size();i++){
//            if (testDataSets.get(i).getTestcaseID().equals(testcaseID)){
//                testdataset =  testDataSets.get(i);
//                break;
//            }
//        }
//        return testdataset;
//
//    }

}
