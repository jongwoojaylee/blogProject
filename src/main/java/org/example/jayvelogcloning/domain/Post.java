package org.example.jayvelogcloning.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "POSTS")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private Long likeCnt;

    @ManyToOne
    private Blog blog;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    private Long commentCnt;

    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;


}
