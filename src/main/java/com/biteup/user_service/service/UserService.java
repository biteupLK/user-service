package com.biteup.user_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biteup.user_service.dto.UserRequestDTO;
import com.biteup.user_service.dto.UserResponseDTO;
import com.biteup.user_service.model.User;
import com.biteup.user_service.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDTO createRestaurant(UserRequestDTO req) {

        User user = new User();
        user.setEmail(req.getEmail());
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setMobile(req.getMobile());
        user.setAddress(req.getAddress());

        User saved = userRepository.save(user);
        log.info("User Create Successfully");

        if (saved.getId() == null)
            return new UserResponseDTO(null, "System Error");

        return new UserResponseDTO("User Saved Success", null);
    }

    public UserResponseDTO updateUserByEmail(UserRequestDTO req, String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isEmpty()) {
            return new UserResponseDTO(null, "User not found");
        }

        User user = optionalUser.get();
        user.setFirstName(req.getFirstName());
        user.setLastName(req.getLastName());
        user.setMobile(req.getMobile());
        user.setAddress(req.getAddress());

        User saved = userRepository.save(user);

        if (saved.getId() == null) {
            return new UserResponseDTO(null, "System Error");
        }

        log.info("User updated successfully");

        return new UserResponseDTO("User Update Success", null);
    }

    public List<User> getAllRestaurants() {
        return userRepository.findAll();
    }

    public List<User> getUserByEmail(String email) {
        return userRepository.findAllByEmail(email);
    }
}
