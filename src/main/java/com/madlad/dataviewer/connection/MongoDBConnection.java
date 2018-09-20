package com.madlad.dataviewer.connection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.madlad.dataviewer.model.ConnectionDetails;
import com.madlad.dataviewer.query.MongoDocumentResult;
import com.madlad.dataviewer.query.MongoQueryParameters;
import com.madlad.dataviewer.query.QueryResult;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection extends DBConnection<MongoClient> {

	public MongoDBConnection(MongoClient connection, ConnectionDetails details) {
		super(connection, details);
	}

	@Override
	public QueryResult<List<Document>> search(String query, Map<String, String> parameters) {
		BasicDBObject queryDbObject = BasicDBObject.parse(query);
		MongoDatabase database = connection.getDatabase(parameters.get(MongoQueryParameters.DB));
		MongoCollection<Document> collection = database.getCollection(parameters.get(MongoQueryParameters.COLLECTION));
		ArrayList<Document> result = collection.find(queryDbObject).into(new ArrayList<>());
		return new MongoDocumentResult(result);
	}

	@Override
	public boolean testConnection() {
		boolean available = false;
		try {
			MongoCursor<String> dbsCursor = connection.listDatabaseNames().iterator();
			while (dbsCursor.hasNext()) {
				available |= dbsCursor.tryNext().equals(details.getDatabase());
			}
		} catch (Exception e) {
			// log
		}

		return available;
	}

}
