package com.hendisantika.springbootoauth2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 8/27/17
 * Time: 5:26 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private long id;

    private String name;

    private String username;

    private int age;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Skill> skills = new HashSet<Skill>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinTable(name = "people_parties",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "party_id", referencedColumnName = "party_id"))
    private Set<Party> parties = new HashSet<Party>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Set<Party> getParties() {
        return parties;
    }

    public void setParties(Set<Party> parties) {
        this.parties = parties;
    }

}
