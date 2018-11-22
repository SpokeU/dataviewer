package com.madlad.dataviewer.connection.provider;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.madlad.dataviewer.connection.exception.ConnectionFailedException;
import com.madlad.dataviewer.entity.ConnectionDetails;
import com.madlad.dataviewer.model.ConnectionType;

@Component
public class PostgresConnectionProvider<Connection> {

	// @Override
	public Connection getConnection(ConnectionDetails details) throws ConnectionFailedException {
		/*
		 * Connection connection;
		 * 
		 * BasicDataSource dataSource = new BasicDataSource();
		 * dataSource.setDriverClassName("org.postgresql.Driver"); //
		 * dataSource.setUrl("jdbc:postgresql://" + details.getHost() + ":" + //
		 * details.getPort()); // dataSource.setUsername(details.getUser()); //
		 * dataSource.setPassword(details.getPassword());
		 * 
		 * try { connection = (Connection) dataSource.getConnection(); } catch
		 * (SQLException e) { e.printStackTrace(); throw new
		 * ConnectionFailedException(e); }
		 */
		return null;
	}

	// @Override
	public List<ConnectionType> handlesTypes() {
		return Arrays.asList(ConnectionType.POSTGRES);
	}

}
