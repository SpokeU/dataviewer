package com.madlad.dataviewer.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Query {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String query;

    @ElementCollection
    private List<String> params;

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

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

}
