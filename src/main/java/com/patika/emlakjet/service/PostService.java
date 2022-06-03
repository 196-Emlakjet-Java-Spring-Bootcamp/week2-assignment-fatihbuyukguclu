package com.patika.emlakjet.service;

import com.patika.emlakjet.domain.Post;
import com.patika.emlakjet.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPost(){
        Optional<List<Post>> optionalPostList = Optional.of(postRepository.findAll());
        return  optionalPostList.orElse(new ArrayList<Post>());
    }

    public List<Post> getPostsByAuthor(String name){
        return Optional.of(postRepository.getPostByAuthor(name)).orElse(new ArrayList<Post>());
    }

    public List<Post> getPostsByTitle(String title){
        return Optional.of(postRepository.getPostByTitleContains(title)).orElse(new ArrayList<Post>());
    }

    public List<Post> getPostsByCategory(String category){
        return Optional.of(postRepository.findByCategory(Post.Category.valueOf(category.toUpperCase()))).orElse(new ArrayList<>());
    }

    public void save(Post post){
        postRepository.save(post);
    }



    public Post updatePost(Post post){
        Post willBeUpdated = postRepository.findById(post.getId()).orElse(new Post());

        if(post.getId() != willBeUpdated.getId()){
            return new Post();
        }

        if(post.getAuthor() != willBeUpdated.getAuthor()){
            willBeUpdated.setAuthor(post.getAuthor());
        }

        if(post.getTitle() != willBeUpdated.getTitle()){
            willBeUpdated.setTitle(post.getTitle());
        }

        if(post.getText() != willBeUpdated.getText()){
            willBeUpdated.setText(post.getText());
        }

        if(post.getCategory() != willBeUpdated.getCategory()){
            willBeUpdated.setCategory(post.getCategory());
        }

        willBeUpdated.setUpdatedBy(post.getAuthor());
        willBeUpdated.setUpdatedAt(Date.from(Instant.now()));

        return postRepository.save(willBeUpdated);
    }
}
