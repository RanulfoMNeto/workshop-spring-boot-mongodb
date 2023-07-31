package com.ranulfoneto.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ranulfoneto.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {
    
}
