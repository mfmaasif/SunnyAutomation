package com.wiley.ranku.steps;

import com.mongodb.client.model.Filters;
import com.thoughtworks.gauge.Step;
import com.wiley.ranku.TestBase;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.thoughtworks.gauge.Step;
import com.wiley.ranku.TestBase;
import org.bson.Document;
import org.junit.Assert;

import java.util.HashMap;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

public class DatabaseVerificationSteplmpl extends TestBase {

    @Step("Connect to Database and verify RFI data")
    public void ConnectDBAndVerifyRFISubmit(){
        MongoClientURI uri = new MongoClientURI("mongodb://RankuDeveloper:OctopusShootBlackInk@aardvark-development-shard-00-00-kgjrm.gcp.mongodb.net/?authSource=admin&ssl=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase databasename = mongoClient.getDatabase("ranku_development");
        MongoCollection<Document> collection = databasename.getCollection("main.inquiries");
        //get mail
        String email = dataset.get("emailAddress");
        Document document = new Document();
        document = collection.find((eq("from.email",email))).sort(eq("createdAt",-1)).first();
        Assert.assertTrue(dataset.get("intrestProgram").contains(document.get("program_name").toString()));
        Document from = (Document) document.get("from");
        Assert.assertEquals(dataset.get("firstName"),from.get("first_name"));
        Assert.assertEquals(dataset.get("lastName"),from.get("last_name"));
    }

    @Step("Connect to Database and verify program RFI data")
    public void ConnectDBAndVerifyProgramPageRFISubmit(){
        MongoClientURI uri = new MongoClientURI("mongodb://RankuDeveloper:OctopusShootBlackInk@aardvark-development-shard-00-00-kgjrm.gcp.mongodb.net/?authSource=admin&ssl=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase databasename = mongoClient.getDatabase("ranku_development");
        MongoCollection<Document> collection = databasename.getCollection("main.inquiries");
        //get mail
        String email = dataset.get("emailAddress");
        Document document = new Document();
        document = collection.find((eq("from.email",email))).sort(eq("createdAt",-1)).first();
        Assert.assertTrue(dataset.get("ProgramName").contains(document.get("program_name").toString()));
        Document from = (Document) document.get("from");
        Assert.assertEquals(dataset.get("firstName"),from.get("first_name"));
        Assert.assertEquals(dataset.get("lastName"),from.get("last_name"));
    }

    @Step("Connect to Database and verify RFI with additional programs")
    public void ConnectDBAndVerifyRFIWithOneClickSubmit(){
        MongoClientURI uri = new MongoClientURI("mongodb://RankuDeveloper:OctopusShootBlackInk@aardvark-development-shard-00-00-kgjrm.gcp.mongodb.net/?authSource=admin&ssl=true");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase databasename = mongoClient.getDatabase("ranku_development");
        MongoCollection<Document> collection = databasename.getCollection("main.inquiries");
        String email = dataset.get("emailAddress");
        Document document = new Document();
        String DbProgramName[] = dataset.get("intrestProgram").split("at");
        //        document = collection.find((eq("from.email",email))).sort(eq("program_name",dataset.get("intrestProgram"))).first();
        document = collection.find(Filters.and(Filters.eq("from.email",email),Filters.regex("program_name",DbProgramName[0].trim()))).first();
//        document = collection.find(Filters.and(Filters.eq("","")), Filters(eq("",""))).first();
        Document from = (Document) document.get("from");
        Assert.assertEquals(dataset.get("firstName"),from.get("first_name"));
        Assert.assertEquals(dataset.get("lastName"),from.get("last_name"));
        String additionalProgram[] = dataset.get("additionalProgram").split(",");
        for (int i=0; i < additionalProgram.length; i++){
            document = collection.find(Filters.and(Filters.eq("from.email",email),Filters.regex("program_name",additionalProgram[i]))).first();
            Assert.assertEquals(dataset.get("firstName"),from.get("first_name"));
            Assert.assertEquals(dataset.get("lastName"),from.get("last_name"));
        }
    }
}
