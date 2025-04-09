package com.biteup.user_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biteup.user_service.dto.UserRequestDTO;
import com.biteup.user_service.dto.UserResponseDTO;
import com.biteup.user_service.model.User;
import com.biteup.user_service.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> createProducts(
            @RequestBody UserRequestDTO req) {
        UserResponseDTO res = userService.createRestaurant(req);
        if (res.getError() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        }
    }

    @GetMapping
    public List<User> getAllProducts() {
        return userService.getAllRestaurants();
    }

    @GetMapping("/{email}")
    public List<User> getUserByEmail(
            @PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping("/{email}")
    public ResponseEntity<UserResponseDTO> updateUserByEmail(
            @RequestBody UserRequestDTO req,
            @PathVariable String email) {
        UserResponseDTO res = userService.updateUserByEmail(req, email);
        if (res.getError() != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(res);
        }
    }

}
