package com.codeup.blog.blog.controllers;
import com.codeup.blog.blog.controllers.Posts;
import com.codeup.blog.blog.models.Post;
import java.util.ArrayList;
import java.util.List;

public class PostListDAO implements Posts {
    private List<Post> posts;

    public List<Post> all() {
        if (posts == null) {
            posts = generatePosts();
        }
        return posts;
    }

    public Long insert(Post post) {
        // make sure we have ads
        if (posts == null) {
            posts = generatePosts();
        }
        // we'll assign an "id" here based on the size of the ads list
        // really the dao would handle this
        post.setId((long) posts.size());
        posts.add(post);
        return post.getId();
    }

    private List<Post> generatePosts() {
        List<Post> posts = new ArrayList<>();

        posts.add(new Post(1, "Title 1", "Title Body"));
        posts.add(new Post(2, "Title Two", "Get your game on with this old-school classic!"));
        posts.add(new Post(3, "Title Three", "Minimum 7 years of experience required. You will be working in the scripting language for Java, JavaScript"));
        posts.add(new Post(4, "Title Four", "Must have strong Java skills"));
        return posts;
    }
}