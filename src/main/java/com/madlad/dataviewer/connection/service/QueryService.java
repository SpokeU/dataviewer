package com.madlad.dataviewer.connection.service;

import com.madlad.dataviewer.entity.QueryEntity;
import com.madlad.dataviewer.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryService {

    @Autowired
    private QueryRepository queryRepository;


    public List<QueryEntity> getAll(){
        return queryRepository.findAll();
    }

    public QueryEntity saveQuery(QueryEntity query){
        return queryRepository.save(query);
    }
}
