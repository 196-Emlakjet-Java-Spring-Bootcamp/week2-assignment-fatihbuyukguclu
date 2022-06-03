package com.patika.emlakjet.controller;

import com.patika.emlakjet.domain.Post;
import com.patika.emlakjet.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPost(){
        List<Post> allPostList = postService.getAllPost();
        return new ResponseEntity<>(allPostList, HttpStatus.OK);
    }

    @GetMapping("/author/{name}")
    public ResponseEntity<List<Post>> getPostsByAuthor(@PathVariable String name){
        List<Post> postList = postService.getPostsByAuthor(name);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Post>> getPostsByTitle(@PathVariable String title){
        List<Post> postList = postService.getPostsByTitle(title);
        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Post>> getPostsByCategory(@PathVariable String category){
        List<Post> postList = postService.getPostsByCategory(category);

        return new ResponseEntity<>(postList, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Post> updatePost(@RequestBody Post post){
        Post updatedPost = postService.updatePost(post);

        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }
}
