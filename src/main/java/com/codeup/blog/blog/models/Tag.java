package com.codeup.blog.blog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED")
    private int id;
    @Column( length = 50)
    private  String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_tag",
            joinColumns = {@JoinColumn(name="tag_id")},
            inverseJoinColumns = {@JoinColumn(name="post_id")}
    )
    private List<Post> posts;

    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    public Tag(String name, List<Post> posts) {
        this.name = name;
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
//<!--    Details:<br>-->
//<!--    Is this post awesome?<br>-->
//<!--    <input type=" checkbox" name="is_awesome" th:checked="true"/>-->
//<!--        History:<br>-->
//<!--        <input type="text" name="history_of_post">-->
//<!--        <br>-->
//<!--        &lt;!&ndash;    <label for="description">Body</label>&ndash;&gt;-->
//<!--        &lt;!&ndash;    <input type="text" placeholder="Enter post info" th:field="*{}">&ndash;&gt;-->
//<!--        &lt;!&ndash;    <br>&ndash;&gt;-->
//<!--        Image Title:<br>-->
//<!--        <input type="text" name="image_title">-->
//<!--        <br><br>-->
//<!--        Images:<br>-->
//<!--        <input type="text" name="post_image_1">-->
//<!--        <input type="text" name="post_image_2">-->
//<!--        <input type="text" name="post_image_3">-->
//<!--        <br><br>-->
//<!--        Tags:<br>-->
//
//<!--        <br><br>-->
//<!--        <input type="submit" value="Submit">-->