package com.madlad.dataviewer.config;

import com.madlad.dataviewer.connection.provider.ConnectionProvider;
import com.madlad.dataviewer.model.ConnectionType;

public interface Dataviewer<D, C extends ConnectionProvider<D, ?>> {

	ConnectionType type();

	Class<D> connectionDetailsClass();

	C connectionProvider();

}
