package com.codeup.blog.blog.repositories;

import com.codeup.blog.blog.models.Post;
import com.codeup.blog.blog.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    List<Tag> findByName(String name);
}
