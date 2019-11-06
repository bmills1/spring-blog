package com.codeup.blog.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "dogs" , uniqueConstraints=
@UniqueConstraint(name ="UK_name_AND_reside_state", columnNames = {"name", "resideState"}))
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "int(11) UNSIGNED")
    private long id;

    @Column(nullable = false, columnDefinition = "tinyint(3) UNSIGNED", unique = true)
    private int age;


    @Column(nullable = false, length =100)
    private String name;

    @Column(columnDefinition = "char(2) DEFAULT 'GA'")
    private String resideState;

    public Dog(long id, int age, String name, String resideState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}
