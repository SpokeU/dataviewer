package com.madlad.dataviewer.connection.provider;

import java.util.List;

import com.madlad.dataviewer.connection.DBConnection;
import com.madlad.dataviewer.model.ConnectionDetails;
import com.madlad.dataviewer.model.ConnectionType;

public interface ConnectionProvider<T> {

	public DBConnection<T> getConnection(ConnectionDetails details);

	public List<ConnectionType> handlesTypes();

}
