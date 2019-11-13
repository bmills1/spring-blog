package com.codeup.blog.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "post_images")
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private int id;
    @Column( length = 100)
    private String image_title;
    @Column( length = 1000)
    private String url;

    @ManyToOne
    @JoinColumn (name = "post_id")
    private Post post;

    public PostImage() {
    }

    public PostImage(String image_title, String url) {
        this.image_title = image_title;
        this.url = url;
    }

    public PostImage(int id, String image_title, String url) {
        this.id = id;
        this.image_title = image_title;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage_title() {
        return image_title;
    }

    public void setImage_title(String image_title) {
        this.image_title = image_title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    //
//    id (typical primary key annotations)
//    image_title VARCHAR(100) NOT NULL
//    url VARCHAR(1000) NOT NULL - the url is for simple hot linking of images for now
//    post_id (a FK that will be created with the proper One-To-Many mapping)
//2. Seed your posts table with a blog post about cats
//3. Seed your post_images table with three images related to cats (use a hot-linked address for now).
//            4. Create a simple view that includes displays the title of the cat blog post the three images
//5 (BONUS). Add a form to add additional images to the cat blog post.

}
