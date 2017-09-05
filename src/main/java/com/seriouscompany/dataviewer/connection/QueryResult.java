package com.seriouscompany.dataviewer.connection;

public abstract class QueryResult<T> {

    private T result;

    public QueryResult(T result) {
        this.result = result;
    }

    public abstract String asString();

    public T getResult() {
        return result;
    }
}
