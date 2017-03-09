package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.TollUsage;

@Repository
public interface TollRepository extends MongoRepository<TollUsage, String> {

}
