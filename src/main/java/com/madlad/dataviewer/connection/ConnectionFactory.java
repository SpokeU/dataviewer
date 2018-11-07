package com.madlad.dataviewer.connection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.madlad.dataviewer.config.Dataviewer;
import com.madlad.dataviewer.connection.provider.ConnectionProvider;
import com.madlad.dataviewer.model.ConnectionDetails;
import com.madlad.dataviewer.utils.ViewerUtils;

@Component
public class ConnectionFactory {

	@Autowired
	private List<Dataviewer<?, ?>> viewers;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DBConnection<?> getConnection(ConnectionDetails details) {

		ConnectionProvider provider = ViewerUtils.findByType(viewers, details.getType()).connectionProvider();
		return provider.getConnection(details);
	}

}
