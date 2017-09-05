package com.seriouscompany.dataviewer.connection.provider;

import com.seriouscompany.dataviewer.model.ConnectionDetails;

public interface ConnectionProvider {

    public <T> T getConnection(ConnectionDetails details);

}
