package com.example;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.model.TollUsage;

//@Repository
@RestResource(path="/tolls")
public interface TollRepository extends MongoRepository<TollUsage, String> {

}
