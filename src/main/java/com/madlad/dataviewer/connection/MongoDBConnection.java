package com.madlad.dataviewer.connection;

import java.util.ArrayList;
import java.util.Map;

import org.bson.Document;

import com.madlad.dataviewer.query.MongoDocumentResult;
import com.madlad.dataviewer.query.MongoQueryParameters;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection extends DBConnection<MongoClient> {

	public MongoDBConnection(MongoClient connection) {
		super(connection);
	}

	@Override
	public MongoDocumentResult search(String query, Map<String, String> parameters) {
		BasicDBObject queryDbObject = BasicDBObject.parse(query);
		MongoDatabase database = connection.getDatabase(parameters.get(MongoQueryParameters.DB));
		MongoCollection<Document> collection = database.getCollection(parameters.get(MongoQueryParameters.COLLECTION));
		ArrayList<Document> result = collection.find(queryDbObject).into(new ArrayList<>());
		return new MongoDocumentResult(result);
	}

	/**
	 * TODO: test
	 */
	@Override
	public boolean testConnection() {
		try {
			return connection.getAddress() != null;
		} catch (Exception e) {
			// log
		}

		return false;
	}

}
