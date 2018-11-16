package com.madlad.dataviewer.model;

import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Query {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String query;

    @ElementCollection
    private Map<String,String> params;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Map<String,String> getParams() {
        return params;
    }

    public void setParams(Map<String,String> params) {
        this.params = params;
    }

}
