package com.seriouscompany.dataviewer.controller;

import com.seriouscompany.dataviewer.connection.ConnectionProvider;
import com.seriouscompany.dataviewer.dao.ConnectionRestRepository;
import com.seriouscompany.dataviewer.model.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("connection")
public class ConnectionController {

    @Autowired
    private ConnectionProvider connectionProvider;

    @Autowired
    private ConnectionRestRepository connectionRestRepository;

    @RequestMapping(path = "/{id}/runQuery", method = RequestMethod.POST)
    public String run(Integer id, @RequestBody RunQueryParameters params) {
        Connection connection = connectionRestRepository.getOne(Long.valueOf(id));
        connectionProvider.get(connection)
        return null;
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
