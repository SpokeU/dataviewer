package com.madlad.dataviewer.connection.provider;

import com.madlad.dataviewer.connection.DBConnection;
import com.madlad.dataviewer.entity.ConnectionDetails;

/**
 * 
 * @author Oleksandr_Myshko
 * 
 * Connection provider is responsible for getting connection details model and creating Connection from it
 * 
 * @param <D> Connection details model
 * @param <R> Connection object
 */
public interface ConnectionProvider<D,R extends DBConnection<?>> {

	public R getConnection(D details);

}
