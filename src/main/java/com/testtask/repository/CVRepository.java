package com.testtask.repository;

import com.testtask.entity.CVEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CVRepository extends MongoRepository<CVEntity, UUID> {
}
