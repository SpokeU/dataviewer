package com.madlad.dataviewer.connection.provider;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.madlad.dataviewer.connection.DBConnection;
import com.madlad.dataviewer.connection.MongoDBConnection;
import com.madlad.dataviewer.model.ConnectionDetails;
import com.madlad.dataviewer.model.ConnectionType;
import com.mongodb.MongoClient;

@Component
public class MongoConnectionProvider implements ConnectionProvider<MongoClient> {

	public DBConnection<MongoClient> getConnection(ConnectionDetails details) {
		MongoClient mongo = new MongoClient(details.getHost(), details.getPort());
		//TODO: connection pooling!
		return new MongoDBConnection(mongo, details);
	}

	@Override
	public List<ConnectionType> handlesTypes() {
		return Arrays.asList(ConnectionType.MONGO);
	}

}
