package com.madlad.dataviewer.connection.service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.madlad.dataviewer.config.Dataviewer;
import com.madlad.dataviewer.entity.ConnectionDetailsEntity;
import com.madlad.dataviewer.reflection.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madlad.dataviewer.connection.ConnectionFactory;
import com.madlad.dataviewer.model.ConnectionType;
import com.madlad.dataviewer.query.QueryResult;
import com.madlad.dataviewer.repository.ConnectionRepository;
import com.madlad.dataviewer.utils.ViewerUtils;

@Service
public class ConnectionService {

    @Autowired
    private ConnectionRepository repository;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private ViewerUtils viewers;

    @Autowired
    private ModelMapper modelMapper;

    public List<ConnectionType> getAvailableConnectionTypes() {
        return viewers.findAll().stream().map(v -> v.type()).collect(Collectors.toList());
    }

    public List<String> getAvailableParametersForConnection(ConnectionType type) {
        Class<?> connectionDetailsClass = viewers.findByType(type).connectionDetailsClass();
        List<Field> fields = Arrays.asList(connectionDetailsClass.getDeclaredFields());
        return fields.stream().map(field -> field.getName()).collect(Collectors.toList());
    }

    //TODO Implement comments
    public ConnectionDetailsEntity saveConnection(String name, ConnectionType type, Map<String, String> parameters) {
        // convert to object connectionDetailsClass by type
        // validate through JSR if everything is present etc.
        // details.setType(type);
        ConnectionDetailsEntity details = new ConnectionDetailsEntity(name, type, parameters);
        return repository.save(details);
    }

    public ConnectionDetailsEntity updateConnection(Long id, String name, ConnectionType type, Map<String, String> parameters) {
        // convert to object connectionDetailsClass by type
        // validate through JSR if everything is present etc.
        // details.setType(type);
        ConnectionDetailsEntity details = new ConnectionDetailsEntity(name, type, parameters);
        details.setId(id);
        return repository.save(details);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<ConnectionDetailsEntity> getById(Long id) {
        return repository.findById(id);
    }

    //TODO implement
    public boolean testConnection(Long connectionId) {
        Optional<ConnectionDetailsEntity> connectionDetails = getById(connectionId);
        ConnectionDetailsEntity details = connectionDetails.get();

        Dataviewer dataviewer = viewers.findByType(details.getType());
        Class<?> detailsClass = dataviewer.connectionDetailsClass();
        Object detailsModel = modelMapper.map(detailsClass, details.getConnectionParameters());

        //find connection provider
        //pass connectionModel to provider to get a connnection
        //invoke test

        //connectionDetails.map(details -> )
        //DBConnection<?> connection = connectionFactory.getConnection(HibernateUtils.unproxy(connectionDetails, ConnectionDetailsEntity.class));
        return dataviewer.connectionProvider().getConnection(detailsModel).testConnection();
    }

    public QueryResult<?> runQuery() {
        return null;
    }

/*    private <T> T convertConnectionDetails(ConnectionDetailsEntity details){
        Class<?> viewer = viewers.findByType(details.getType()).connectionDetailsClass();
        return modelMapper.map(viewer, details.getConnectionParameters());
    }*/
}
