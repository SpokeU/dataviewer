package com.madlad.dataviewer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.madlad.dataviewer.connection.ConnectionFactory;
import com.madlad.dataviewer.connection.DBConnection;
import com.madlad.dataviewer.model.ConnectionDetails;
import com.madlad.dataviewer.query.QueryResult;
import com.madlad.dataviewer.repository.rest.ConnectionRestRepository;

@RestController
@RequestMapping("connection")
public class ConnectionController {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private ConnectionRestRepository connectionRestRepository;
    
    
    /**
     * 
     *     Connection<Typed with connection inside>.executeQuery
     *     QueryResult<typed with result type>
     * 
     */
    @RequestMapping(path = "/{id}/runQuery", method = RequestMethod.POST)
    public ResponseEntity<QueryResult<?>> run(@PathVariable Integer id, @RequestBody RunQueryParameters params) {
        ConnectionDetails connectionDetails = connectionRestRepository.getOne(Long.valueOf(id));
        
        DBConnection<?> connection = connectionFactory.getConnection(connectionDetails);
        QueryResult<?> result = connection.search(params.getQueryString(), params.getQueryParams());
        return new ResponseEntity<QueryResult<?>>(result, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/{id}/test", method = RequestMethod.GET)
    public boolean testConnection(@PathVariable Integer id) {
    	ConnectionDetails connectionDetails = connectionRestRepository.getOne(Long.valueOf(id));
        DBConnection<?> connection = connectionFactory.getConnection(connectionDetails);
		return connection.testConnection();
    }
    
    /**
     * TODO: Implement
     * 
     * Returns list of required fields for particular connection type.
     * This is required by UI in order to display create connection page. 
     * 
     * TODO: Connection details should be abstract and subclasses will declare all required fields for particular
     * 
     */
    @RequestMapping(path = "fields", method = RequestMethod.GET)
    public List<String> getFieldsForConnectionType(){
    	return null;
    }
    
    @PostMapping("/test")
    public boolean testConnection(@RequestBody ConnectionDetails details) {
		return false;
    }


    public static class RunQueryParameters {
        private String queryString;
        private Integer queryId;
        private Map<String, String> queryParams;

        public String getQueryString() {
            return queryString;
        }

        public void setQueryString(String queryString) {
            this.queryString = queryString;
        }

        public Integer getQueryId() {
            return queryId;
        }

        public void setQueryId(Integer queryId) {
            this.queryId = queryId;
        }

        public Map<String, String> getQueryParams() {
            return queryParams;
        }

        public void setQueryParams(Map<String, String> queryParams) {
            this.queryParams = queryParams;
        }
    }

}
