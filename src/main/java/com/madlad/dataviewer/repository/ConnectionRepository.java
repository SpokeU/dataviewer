package com.madlad.dataviewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madlad.dataviewer.entity.ConnectionDetailsEntity;

public interface ConnectionRepository extends JpaRepository<ConnectionDetailsEntity, Long>{

}
