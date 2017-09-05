package com.seriouscompany.dataviewer.connection;

import com.seriouscompany.dataviewer.connection.provider.ConnectionProvider;
import com.seriouscompany.dataviewer.connection.provider.MongoConnectionProvider;
import com.seriouscompany.dataviewer.connection.provider.PostgresConnectionProvider;
import com.seriouscompany.dataviewer.model.ConnectionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConnectionFactory {

    @Autowired
    private ConnectionProvider postgresConnectionProvider;

    public DBConnection getConnection(ConnectionDetails details) {
        switch (details.getType()){
            case MONGO:
                break;
            case MYSQL: break;
            case POSTGRES:
                return postgresConnectionProvider.getConnection(details);
            case MSSQL: break;
        }
        return null;
    }

}
