package com.codeup.blog.blog.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private long id;
    @Column(nullable = false, length = 100, unique = true)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String body;
    @OneToOne
    private PostDetails postDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> postImages;
    @ManyToMany(mappedBy = "posts")
    private List<Tag> tags;
    @ManyToOne
    @JoinColumn (name = "user_id")
    private User user;

    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }


    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

    public Post(String title, String body, PostDetails postDetails, List<PostImage> postImages, List<Tag> tags, User user) {
        this.title = title;
        this.body = body;
        this.postDetails = postDetails;
        this.postImages = postImages;
        this.tags = tags;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String description) {
        this.body = description;
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }

    public List<PostImage> getPostImages() {
        return postImages;
    }

    public void setPostImages(List<PostImage> postImages) {
        this.postImages = postImages;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
