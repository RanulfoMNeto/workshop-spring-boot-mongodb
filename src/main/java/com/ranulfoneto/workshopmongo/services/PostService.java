package com.ranulfoneto.workshopmongo.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ranulfoneto.workshopmongo.models.Post;
import com.ranulfoneto.workshopmongo.repositories.PostRepository;
import com.ranulfoneto.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
    
    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}
