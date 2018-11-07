package com.madlad.dataviewer;

import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@Controller
public class DataviewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataviewerApplication.class, args);
    }

    @RequestMapping(path = "/test", method = RequestMethod.GET)
    @ResponseBody
    public String add() {
    	//ConnectionProvider provider = new MongoConnectionProvider();
    	//ConnectionDetails dbDetails = new DBConnectionDetails();
    	//provider.getConnection(dbDetails);
    	
    	
    	MongoClient mongoClient = new MongoClient("localhost", 27017);
    	MongoDatabase db = mongoClient.getDatabase("test_db");
    	MongoCollection<Document> collection = db.getCollection("test_collection");
		Document result = collection.find(BasicDBObject.parse("{\"username\":\"a\"}")).first();
        return result.toJson();
    }
}
