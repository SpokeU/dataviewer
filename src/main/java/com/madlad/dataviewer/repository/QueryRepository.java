package com.madlad.dataviewer.repository;

import com.madlad.dataviewer.entity.QueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryRepository extends JpaRepository<QueryEntity, Long> {
}
