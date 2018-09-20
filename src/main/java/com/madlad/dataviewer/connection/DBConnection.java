package com.madlad.dataviewer.connection;

import java.util.Map;

import com.madlad.dataviewer.model.ConnectionDetails;
import com.madlad.dataviewer.query.QueryResult;

public abstract class DBConnection<T> {

	protected T connection;
	protected ConnectionDetails details;//TODO: remove. As all required info should be passed to "search" as parameters

	public DBConnection(T connection, ConnectionDetails details) {
		this.connection = connection;
		this.details = details;
	}

	public abstract QueryResult<?> search(String query, Map<String, String> paramenters);

	public abstract boolean testConnection();

}
