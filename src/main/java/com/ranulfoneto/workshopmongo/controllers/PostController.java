package com.ranulfoneto.workshopmongo.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ranulfoneto.workshopmongo.controllers.util.URL;
import com.ranulfoneto.workshopmongo.models.Post;
import com.ranulfoneto.workshopmongo.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
    
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping
    public ResponseEntity<List<Post>> findByTitleContaining(@RequestParam(value = "search", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = postService.findByTitleContaining(text);
        return ResponseEntity.ok().body(posts);
    }

}
