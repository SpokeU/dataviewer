package com.madlad.dataviewer.repository.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.madlad.dataviewer.model.Query;

@RepositoryRestResource(collectionResourceRel = "query", path = "/rest-query")
public interface QueryRestRepository extends PagingAndSortingRepository<Query, Long>{
}
