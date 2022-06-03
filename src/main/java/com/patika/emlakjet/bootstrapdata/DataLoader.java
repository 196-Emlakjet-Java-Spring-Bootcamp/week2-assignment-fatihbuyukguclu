package com.patika.emlakjet.bootstrapdata;

import com.patika.emlakjet.domain.Post;
import com.patika.emlakjet.repository.PostRepository;
import com.patika.emlakjet.service.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {

    public PostRepository postRepository;

    public DataLoader(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Post post1 = new Post();
        post1.setAuthor("Fatih");
        post1.setTitle("Lorem Ipsum1");
        post1.setCategory(Post.Category.CATEGORY1);
        postRepository.save(post1);

        System.out.println(postRepository.getPostByAuthor("Fatih"));

        Post post2 = new Post();
        post2.setAuthor("Fatih");
        post2.setTitle("Lorem Ipsum1");
        post2.setCategory(Post.Category.CATEGORY2);
        postRepository.save(post2);


        Post post3 = new Post();
        post3.setAuthor("Fatih1");
        post3.setTitle("Lorem Ipsum2");
        post3.setCategory(Post.Category.CATEGORY3);
        postRepository.save(post3);
    }


}
