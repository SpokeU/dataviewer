package com.madlad.dataviewer.connection.provider;

import com.madlad.dataviewer.connection.PostgresConnection;
import com.madlad.dataviewer.connection.exception.ConnectionFailedException;
import com.madlad.dataviewer.model.ConnectionType;
import com.madlad.dataviewer.model.DBConnectionDetails;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Component
public class PostgresConnectionProvider implements ConnectionProvider<DBConnectionDetails, PostgresConnection> {

    @Override
    public PostgresConnection getConnection(DBConnectionDetails details) {
        Connection connection;

        BasicDataSource dataSource = new BasicDataSource();

        String url = "jdbc:postgresql://" +
                details.getHost() + ":" +
                details.getPort() + "/" +
                details.getDatabase() + "?";


        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername(details.getUsername());
        dataSource.setPassword(details.getPassword());

        try {
            connection = (Connection) dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ConnectionFailedException(e);
        }

        return null;
    }
}
