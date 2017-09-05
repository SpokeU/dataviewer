package com.seriouscompany.dataviewer.connection.provider;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.seriouscompany.dataviewer.model.ConnectionDetails;
import org.springframework.stereotype.Component;

public class MongoConnectionProvider {

    public Mongo getConnection(ConnectionDetails details){
        MongoClient mongo = new MongoClient(details.getHost(), details.getPort());
        return mongo;
    }

}
