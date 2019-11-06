package com.codeup.blog.blog.controllers;

import com.codeup.blog.blog.models.Post;

import java.util.List;

public interface Posts{
     List<Post> all();
     Long insert(Post post);

}
