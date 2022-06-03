package com.patika.emlakjet.repository;

import com.patika.emlakjet.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> getPostByTitleContains(String title);
    List<Post> getPostByAuthor(String author);
    List<Post> findByCategory(Post.Category category);

}
