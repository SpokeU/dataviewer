package com.seriouscompany.dataviewer.controller;

import com.seriouscompany.dataviewer.connection.ConnectionFactory;
import com.seriouscompany.dataviewer.dao.QueryRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {

    @Autowired
    private QueryRestRepository queryRepository;

    @Autowired
    private ConnectionFactory connectionProvider;

}
