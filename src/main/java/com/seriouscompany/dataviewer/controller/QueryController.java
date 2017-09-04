package com.seriouscompany.dataviewer.controller;

import com.mongodb.MongoClient;
import com.seriouscompany.dataviewer.connection.ConnectionProvider;
import com.seriouscompany.dataviewer.dao.QueryRestRepository;
import com.seriouscompany.dataviewer.model.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
public class QueryController {

    @Autowired
    private QueryRestRepository queryRepository;

    @Autowired
    private ConnectionProvider connectionProvider;

    @RequestMapping(path = "/query/{id}/run", method = RequestMethod.POST)
    public String run(@PathParam("id") Integer id, @RequestBody Map<String, String> parameters){
        Query query = queryRepository.findOne(Long.valueOf(id));
        MongoClient client = connectionProvider.forType(query.getConnection().getType());
        return "";
    }

}
