package com.codeup.blog.blog.repositories;

import com.codeup.blog.blog.models.Post;
import com.codeup.blog.blog.models.Tag;
import org.hibernate.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String string);
    Post deleteById(long id);
    Post  findAllByTagsContaining(String name);


}
