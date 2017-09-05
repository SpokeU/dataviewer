package com.seriouscompany.dataviewer.connection;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection extends DBConnection<MongoDatabase> {

    public MongoDBConnection(MongoDatabase connection) {
        super(connection);
    }

    @Override
    public QueryResult executeQuery(String query) {
        BasicDBObject queryDbObject = BasicDBObject.parse(query);
        return null;
    }
}
