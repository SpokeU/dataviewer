package com.seriouscompany.dataviewer.connection.provider;

import com.seriouscompany.dataviewer.connection.exception.ConnectionFailedException;
import com.seriouscompany.dataviewer.model.ConnectionDetails;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
public class PostgresConnectionProvider implements ConnectionProvider{

    @Override
    public Connection getConnection(ConnectionDetails details) throws ConnectionFailedException{
        Connection connection;

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://" + details.getHost() + ":" + details.getPort());
        dataSource.setUsername(details.getUser());
        dataSource.setPassword(details.getPassword());

        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ConnectionFailedException(e);
        }

        return connection;
    }

}
