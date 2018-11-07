package com.madlad.dataviewer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.madlad.dataviewer.connection.provider.MongoConnectionProvider;
import com.madlad.dataviewer.model.ConnectionType;
import com.madlad.dataviewer.model.DBConnectionDetails;

@Configuration
public class MongoDataViewer implements Dataviewer<DBConnectionDetails, MongoConnectionProvider> {

	@Override
	public ConnectionType type() {
		return ConnectionType.MONGO;
	}


	@Override
	@Bean
	public MongoConnectionProvider connectionProvider() {
		return new MongoConnectionProvider();
	}


	@Override
	public Class<DBConnectionDetails> connectionDetailsClass() {
		return DBConnectionDetails.class;
	}

}
