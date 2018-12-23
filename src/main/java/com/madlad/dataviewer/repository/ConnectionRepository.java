package com.madlad.dataviewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madlad.dataviewer.entity.ConnectionDetails;

public interface ConnectionRepository extends JpaRepository<ConnectionDetails, Long>{

}