package com.madlad.dataviewer.connection.service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madlad.dataviewer.config.Dataviewer;
import com.madlad.dataviewer.connection.ConnectionFactory;
import com.madlad.dataviewer.connection.DBConnection;
import com.madlad.dataviewer.entity.ConnectionDetails;
import com.madlad.dataviewer.model.ConnectionType;
import com.madlad.dataviewer.query.QueryResult;
import com.madlad.dataviewer.repository.ConnectiontRepository;
import com.madlad.dataviewer.utils.HibernateUtils;
import com.madlad.dataviewer.utils.ViewerUtils;

@Service
public class ConnectionService {

	@Autowired
	private ConnectiontRepository repository;
	
	@Autowired
	private ConnectionFactory connectionFactory;

	@Autowired
	private ConnectiontRepository connectionRestRepository;

	@Autowired
	private List<Dataviewer<?, ?>> viewers;

	public List<ConnectionType> getAvaiableConnectionTypes(){
		return viewers.stream().map(v -> v.type()).collect(Collectors.toList());
	}
	
	public List<String> getAvaiableParametersForConnection(ConnectionType type){
		Class<?> connectionDetailsClass = ViewerUtils.findByType(viewers, type).connectionDetailsClass();
		List<Field> fields = Arrays.asList(connectionDetailsClass.getDeclaredFields());
		return fields.stream().map(field -> field.getName()).collect(Collectors.toList());
	}

	//TODO Implement comments
	public ConnectionDetails saveConnection(String name, ConnectionType type, Map<String, String> parameters) {
		// convert to object connectionDetailsClass by type
		// validate through JSR if everything is present etc.
		// details.setType(type);
		ConnectionDetails details = new ConnectionDetails(name, type, parameters);
		return repository.save(details);
	}

	public ConnectionDetails updateConnection(Long id, String name, ConnectionType type, Map<String, String> parameters) {
		// convert to object connectionDetailsClass by type
		// validate through JSR if everything is present etc.
		// details.setType(type);
		ConnectionDetails details = new ConnectionDetails(name, type, parameters);
		details.setId(id);
		return repository.save(details);
	}

	public void delete(Long id){
		repository.deleteById(id);
	}

	public Optional<ConnectionDetails> getById(Long id){
		return repository.findById(id);
	}
	
	public boolean testConnection(Long connectionId){
		ConnectionDetails connectionDetails = connectionRestRepository.getOne(Long.valueOf(connectionId));
		DBConnection<?> connection = connectionFactory.getConnection(HibernateUtils.unproxy(connectionDetails, ConnectionDetails.class));
		return connection.testConnection();
	}
	
	public QueryResult<?> runQuery(){
		return null;
	}

}
