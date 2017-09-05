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

}
