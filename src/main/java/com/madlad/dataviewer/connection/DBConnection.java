package com.madlad.dataviewer.connection;

import java.util.Map;

import com.madlad.dataviewer.query.QueryResult;

public abstract class DBConnection<T> {

	protected T connection;

	public DBConnection(T connection) {
		this.connection = connection;
	}

	public abstract QueryResult<?> search(String query, Map<String, String> parameters);

	public abstract boolean testConnection();

}
