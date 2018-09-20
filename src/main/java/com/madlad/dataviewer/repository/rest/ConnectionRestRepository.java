package com.madlad.dataviewer.repository.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.madlad.dataviewer.model.ConnectionDetails;

@RepositoryRestResource(path = "/rest-connection")
public interface ConnectionRestRepository extends JpaRepository<ConnectionDetails, Long>{
}
