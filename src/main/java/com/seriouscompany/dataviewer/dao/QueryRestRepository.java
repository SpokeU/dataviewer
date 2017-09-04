package com.seriouscompany.dataviewer.dao;

import com.seriouscompany.dataviewer.model.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "query", path = "/rest-query")
public interface QueryRestRepository extends PagingAndSortingRepository<Query, Long>{
}
