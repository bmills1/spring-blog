package com.codeup.blog.blog.repositories;

import com.codeup.blog.blog.models.Post;

import java.util.List;

public interface UserRepositoryCustom {
    List findAll(String email, String username, String password, List<Post> posts);
}
