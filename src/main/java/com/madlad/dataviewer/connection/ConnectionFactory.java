package com.madlad.dataviewer.connection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.madlad.dataviewer.connection.provider.ConnectionProvider;
import com.madlad.dataviewer.model.ConnectionDetails;

@Component
public class ConnectionFactory {

	@Autowired
	private List<ConnectionProvider<?>> connectionProviders;


	public DBConnection<?> getConnection(ConnectionDetails details) {
		ConnectionProvider<?> connectionProvider = connectionProviders
				.stream()
				.filter(provider -> provider.handlesTypes().contains(details.getType()))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No provider for type: " + details.getType() + " found"));
		
		return connectionProvider.getConnection(details);
	}

}
