package org.example.jayvelogcloning.repository;

import org.example.jayvelogcloning.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}
