package com.madlad.dataviewer.connection.service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.madlad.dataviewer.reflection.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madlad.dataviewer.config.Dataviewer;
import com.madlad.dataviewer.connection.ConnectionFactory;
import com.madlad.dataviewer.connection.DBConnection;
import com.madlad.dataviewer.entity.ConnectionDetails;
import com.madlad.dataviewer.model.ConnectionType;
import com.madlad.dataviewer.query.QueryResult;
import com.madlad.dataviewer.repository.ConnectionRepository;
import com.madlad.dataviewer.utils.HibernateUtils;
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

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<ConnectionDetails> getById(Long id) {
        return repository.findById(id);
    }

    //TODO implement
    public boolean testConnection(Long connectionId) {
        Optional<ConnectionDetails> connectionDetails = getById(connectionId);
        ConnectionDetails details = connectionDetails.get();
        Class<?> viewer = viewers.findByType(details.getType()).connectionDetailsClass();


        //connectionDetails.map(details -> )
        //DBConnection<?> connection = connectionFactory.getConnection(HibernateUtils.unproxy(connectionDetails, ConnectionDetails.class));
        return true;
    }

    public QueryResult<?> runQuery() {
        return null;
    }

/*    private <T> T convertConnectionDetails(ConnectionDetails details){
        Class<?> viewer = viewers.findByType(details.getType()).connectionDetailsClass();
        return modelMapper.map(viewer, details.getConnectionParameters());
    }*/
}
