package com.ranulfoneto.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ranulfoneto.workshopmongo.models.User;

public interface UserRepository extends MongoRepository<User, String> {
    
}
