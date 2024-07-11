package org.example.jayvelogcloning.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter @Setter
@Entity
@Table(name = "FOLLOWINGS")
public class Following {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "following_date")
    private LocalDate followingDate;

    @ManyToOne
    private User user;

    @ManyToOne
    private Blog blog;



}
