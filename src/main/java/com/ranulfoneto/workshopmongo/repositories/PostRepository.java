package com.ranulfoneto.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ranulfoneto.workshopmongo.models.Post;

public interface PostRepository extends MongoRepository<Post, String> {
    
}
