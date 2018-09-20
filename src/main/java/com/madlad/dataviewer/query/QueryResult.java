package com.madlad.dataviewer.query;

public abstract class QueryResult<T> {

	public enum Type {
		JSON, TABLE
	}

	protected Type type;
	protected T result;

	public QueryResult(T result) {
		this.result = result;
	}

	public abstract String asString();

	public T getResult() {
		return result;
	}

	public Type getType() {
		return type;
	}	
	
}
