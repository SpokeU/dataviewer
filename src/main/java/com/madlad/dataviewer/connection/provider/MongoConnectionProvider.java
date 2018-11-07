package com.madlad.dataviewer.connection.provider;

import java.util.HashMap;

import com.madlad.dataviewer.connection.MongoDBConnection;
import com.madlad.dataviewer.model.DBConnectionDetails;
import com.mongodb.MongoClient;

public class MongoConnectionProvider implements ConnectionProvider<DBConnectionDetails, MongoDBConnection> {
	
	private HashMap<Integer, MongoDBConnection> pool = new HashMap<>();

	public MongoDBConnection getConnection(DBConnectionDetails details) {
		MongoDBConnection mongo = pool.computeIfAbsent(details.hashCode(), hashCode -> createConnection(details));
		return mongo;
	}
	
	private MongoDBConnection createConnection(DBConnectionDetails details) {
		MongoClient mongo = new MongoClient(details.getHost(), details.getPort());
		return new MongoDBConnection(mongo);
	}

}
