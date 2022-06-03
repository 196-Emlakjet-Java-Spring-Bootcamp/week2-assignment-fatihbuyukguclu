package com.patika.emlakjet.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "post")
@Getter
@Setter
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String title;
    private Date createdAt;
    private Date updatedAt;
    private String updatedBy;
    private String text;
    private Category category;

    public Post(){
        this.createdAt = Date.from(Instant.now());
    }


    public static enum Category {
        CATEGORY1,CATEGORY2,CATEGORY3
    }
}
