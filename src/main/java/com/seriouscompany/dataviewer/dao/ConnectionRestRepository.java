package com.seriouscompany.dataviewer.dao;

import com.seriouscompany.dataviewer.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "/rest-connection")
public interface ConnectionRestRepository extends JpaRepository<Connection, Long>{
}
