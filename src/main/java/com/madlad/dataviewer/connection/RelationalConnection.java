package com.madlad.dataviewer.connection;
import com.madlad.dataviewer.query.QueryResult;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class RelationalConnection extends DBConnection<Connection>{

    public RelationalConnection(Connection connection) {
        super(connection);
    }

    @Override
    public QueryResult<?> search(String query, Map<String, String> parameters) {
        return null;
    }

    @Override
    public boolean testConnection() {
        try {
            return connection.isValid(200);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
