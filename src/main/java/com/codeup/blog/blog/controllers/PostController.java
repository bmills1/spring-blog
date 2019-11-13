package com.codeup.blog.blog.controllers;

import com.codeup.blog.blog.models.*;
import com.codeup.blog.blog.repositories.ImagesRepository;
import com.codeup.blog.blog.repositories.PostRepository;
import com.codeup.blog.blog.repositories.TagRepository;
import com.codeup.blog.blog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

    private PostRepository postDao;
    private ImagesRepository imageDao;
    private TagRepository tagDao;
    private UserRepository userDao;

    public PostController(PostRepository postDao, TagRepository tagDao, UserRepository userDao, ImagesRepository imageDao) {
        this.postDao = postDao;
        this.tagDao = tagDao;
        this.userDao = userDao;
        this.imageDao = imageDao;
    }


    //    GET	/posts	posts index page
    @GetMapping("/posts")
    public String index(Model vModel) {

        vModel.addAttribute("posts", postDao.findAll());
        return "posts/index.html";
    }


    //    GET	/posts/{id}	view an individual post
    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/search")
    public String search(@RequestParam String title, Model vModel) {
        vModel.addAttribute("post", postDao.findByTitle("Chuck"));
        return "posts/show";
    }


    @PostMapping("/posts/delete")
    public String delete(@RequestParam("id") String postId) throws IllegalArgumentException {
        Long id = Long.parseLong(postId);
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit/{id}")
    public String edit(@PathVariable long id, Model vModel) {
        vModel.addAttribute("post", postDao.getOne(id));
        return "/posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String update(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
        Post oldPost = postDao.getOne(id);
        oldPost.setTitle(title);
        oldPost.setBody(body);
        postDao.save(oldPost);
        return "redirect:/posts/" + id;
    }

    //post history
    @GetMapping("/posts/history/{id}")
    public String returnTestView(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/history";
    }


    //add images
    // TESTING ONE TO MANY RELATIONSHIP...
//    @PostMapping("/posts/add-image/{id}")
//    public String addImage(
//            @PathVariable long id,
//            @RequestParam String image_title,
//            @RequestParam String url) {
//
//        PostImage postImage = new PostImage(image_title, url);
//        postImage.setPost(postDao.getOne(id));
//        imageDao.save(postImage);
//
//        return "redirect:/posts/" + id;
//    }

   // return all tags
    @GetMapping("/posts/tag")
    public String getPostTags(Model model) {
        model.addAttribute("tags", tagDao.findAll());
        return "posts/tag";
    }

    //return posts by tag
    @GetMapping("/posts/tag/{name}")
    public String getPostTags(@PathVariable String name, Model model) {
        model.addAttribute("posts", postDao.findAllByTagsContaining(name));
        return "posts/tag/" + name;
    }


    @PostMapping("/posts/tag/{id}")
    public String assignNewTagToPost(
            @PathVariable long id,
            @RequestParam String name
    ) {

        Post post = postDao.getOne(id);

        // create a new vet and associate the vet with a given pet
        tagDao.save(new Tag(name, Arrays.asList(post)));

        return "redirect:/posts/" + id;
    }


    //    GET	/posts/create	view the form for creating a post
    @GetMapping("/posts/create")

    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("tags", tagDao.findAll());
        return "posts/create";
    }

    ////    POST	/posts/create	create a new post
    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post postToBeCreated){
        postToBeCreated.setUser(userDao.getOne(1));
        Post savedPost = postDao.save(postToBeCreated);
        return "redirect:/posts/" + savedPost.getId();
    }
}
