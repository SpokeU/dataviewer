package com.seriouscompany.dataviewer.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Query {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String query;

    @OneToMany(mappedBy = "query")
    private List<QueryParam> params;

    private Connection connection;

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

    public List<QueryParam> getParams() {
        return params;
    }

    public void setParams(List<QueryParam> params) {
        this.params = params;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
