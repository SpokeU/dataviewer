package com.madlad.dataviewer.entity;

import javax.persistence.*;

@Entity(name = "query")
public class QueryEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Column(name = "query_string")
    private String queryString;

    @ManyToOne
    @JoinColumn(name = "connection_id")
    private ConnectionDetailsEntity connectionDetailsEntity;


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

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public ConnectionDetailsEntity getConnectionDetailsEntity() {
        return connectionDetailsEntity;
    }

    public void setConnectionDetailsEntity(ConnectionDetailsEntity connectionDetailsEntity) {
        this.connectionDetailsEntity = connectionDetailsEntity;
    }
}
