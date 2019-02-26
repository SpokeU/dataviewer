package com.madlad.dataviewer.controller;

import com.madlad.dataviewer.connection.service.QueryService;
import com.madlad.dataviewer.entity.QueryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("query")
public class QueryController {

    @Autowired
    private QueryService queryService;

    //TODO for mogno like aggregation part collection part etc.
	/*@GetMapping("/parameters")
	public List<String> parameters(@RequestParam String type) {
		return null;
	}*/

	@GetMapping
    public List<QueryEntity> getAll() {
        return queryService.getAll();
    }

    @PostMapping
    public QueryEntity save(@RequestBody QueryEntity query){
        return queryService.saveQuery(query);
    }
}
