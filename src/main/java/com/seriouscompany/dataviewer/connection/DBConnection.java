package com.seriouscompany.dataviewer.connection;

import com.seriouscompany.dataviewer.model.Query;

public abstract class DBConnection<T> {

    protected T connection;

    public DBConnection(T connection){
        this.connection = connection;
    }

    public abstract QueryResult executeQuery(String query);

}
