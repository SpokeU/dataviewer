package com.madlad.dataviewer.config;

import com.madlad.dataviewer.connection.provider.PostgresConnectionProvider;
import com.madlad.dataviewer.model.ConnectionType;
import com.madlad.dataviewer.model.DBConnectionDetails;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgresDataViewer implements Dataviewer<DBConnectionDetails, PostgresConnectionProvider>{
    @Override
    public ConnectionType type() {
        return ConnectionType.POSTGRES;
    }

    @Override
    public Class<DBConnectionDetails> connectionDetailsClass() {
        return DBConnectionDetails.class;
    }

    @Override
    public PostgresConnectionProvider connectionProvider() {
        return new PostgresConnectionProvider();
    }
}
