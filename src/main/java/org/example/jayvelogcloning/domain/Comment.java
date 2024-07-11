package org.example.jayvelogcloning.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Entity
@Table(name = "COMMENTS")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    private String content;

    private Boolean deleted = false;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
}
