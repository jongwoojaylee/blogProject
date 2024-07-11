package org.example.jayvelogcloning.service;

import lombok.RequiredArgsConstructor;
import org.example.jayvelogcloning.domain.Blog;
import org.example.jayvelogcloning.domain.Role;
import org.example.jayvelogcloning.domain.User;
import org.example.jayvelogcloning.repository.BlogRepository;
import org.example.jayvelogcloning.repository.RoleRepository;
import org.example.jayvelogcloning.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final BlogRepository blogRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User saveUser(User user) {

        Optional<Role> roleUser = roleRepository.findByName("ROLE_USER");
        if (!roleUser.isPresent()) {
            throw new RuntimeException("ROLE_USER not found");
        }
        user.setRoles(new HashSet<>(Collections.singletonList(roleUser.get())));
        user.setRegDate(LocalDate.now());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Blog blog = new Blog();
        blog.setOwner(user);
        blog.setTitle(user.getName()+"의 블로그");
        blog.setIntroduction("자기소개를 입력해주세요.");
        blog.setFollowerCount(0L);

        user.setBlog(blog);

        userRepository.save(user);

        return user;
    }

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }
    public boolean isEmailExist(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent();
    }
    public boolean isUsernameExist(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.isPresent();
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public void deleteById(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }


}
