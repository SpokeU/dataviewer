package com.madlad.dataviewer.connection;

import java.sql.Connection;

public class PostgresConnection extends RelationalConnection{

    public PostgresConnection(Connection connection) {
        super(connection);
    }
}
