package com.madlad.dataviewer.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.madlad.dataviewer.connection.provider.ConnectionProvider;
import com.madlad.dataviewer.entity.ConnectionDetailsEntity;
import com.madlad.dataviewer.utils.ViewerUtils;

@Component
public class ConnectionFactory {

	@Autowired
	private ViewerUtils viewers;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DBConnection<?> getConnection(ConnectionDetailsEntity details) {

		ConnectionProvider provider = viewers.findByType(details.getType()).connectionProvider();
		return provider.getConnection(details);
	}

}
