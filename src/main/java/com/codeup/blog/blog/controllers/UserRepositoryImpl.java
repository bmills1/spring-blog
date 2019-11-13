//package com.codeup.blog.blog.controllers;
//
//import com.codeup.blog.blog.models.*;
//import com.codeup.blog.blog.repositories.UserRepositoryCustom;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserRepositoryImpl implements UserRepositoryCustom {
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List findAll(String email, String username, String password, List<Post> posts) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery query = cb.createQuery(User.class);
//        Root userRoot = query.from(User.class);
//        Root postRoot = query.from(Post.class);
//        Root postImageRoot = query.from(PostImage.class);
//        Root postDetailsRoot = query.from(PostDetails.class);
//        Root tagRoot = query.from(Tag.class);
//
//
//        List filterPredicates = new ArrayList();
//        filterPredicates.add(cb.equal(postRoot.get("userId"), userRoot.get("id")));
//        if (posts != null && !posts.isEmpty()) {
//            filterPredicates.add(cb.like(posts.));
//        }
////        query.select(cb.construct(BookDto.class,
////                bookRoot.get("label"), authorRoot.get("familyName"), authorRoot.get("name"), bookRoot.get("pageCount")))
////                .where(cb.and(filterPredicates.toArray(new Predicate[0])))
////);
////        return entityManager.createQuery(query).getResultList();
////    }
//
//
//}
