package com.codeup.blog.blog.controllers;

import com.codeup.blog.blog.models.Post;
import com.codeup.blog.blog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }



    //    GET	/posts	posts index page
@GetMapping("/posts")
public String index( Model vModel) {

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
        return "posts/show";}



    @PostMapping("/posts/delete")
    public String delete(@RequestParam("id") String postId) throws IllegalArgumentException {
        Long id = Long.parseLong(postId);
            postDao.deleteById(id);
        return "redirect:/posts";
    }
    @GetMapping("/posts/edit/{id}")
    public String edit(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }
    @PostMapping("/posts/edit/{id}")
    public String update(@PathVariable long id, @RequestParam String title, @RequestParam String body) {
        Post oldPost = postDao.getOne(id);
        oldPost.setTitle(title);
        oldPost.setBody(body);
        postDao.save(oldPost);
        return "redirect:/posts/" + id;
    }


//    GET	/posts/create	view the form for creating a post
//@GetMapping("/posts/create")
//
//public String showCreateForm() {
//    return "posts/create";
//}
////    POST	/posts/create	create a new post
//@PostMapping("/posts/create")
//public String create(@RequestParam String title, @RequestParam String body) {
//
//    return "posts";
//}



}
