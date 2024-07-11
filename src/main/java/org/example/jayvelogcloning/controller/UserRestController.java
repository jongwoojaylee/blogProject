package org.example.jayvelogcloning.controller;

import lombok.RequiredArgsConstructor;
import org.example.jayvelogcloning.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RequiredArgsConstructor
@RestController
public class UserRestController {
    private final UserService userService;

    @GetMapping("/api/users/check-username")
    public Map<String, Boolean> checkUsername(@RequestParam String username) {
        boolean exists = userService.isUsernameExist(username);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return response;
    }

    @GetMapping("/api/users/check-email")
    public Map<String, Boolean> checkEmail(@RequestParam String email) {
        boolean exists = userService.isEmailExist(email);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return response;
    }
}
