package org.example.jayvelogcloning.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter
@Entity
@Table(name = "BLOGS")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String introduction;

    @OneToOne
    private User owner;

    @OneToMany(mappedBy = "blog")
    private List<Following> followings = new ArrayList<>();

    @OneToMany(mappedBy = "blog")
    private List<Post> posts = new ArrayList<>();

    private Long followerCount;

}
