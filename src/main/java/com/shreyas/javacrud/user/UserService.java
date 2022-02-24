package com.shreyas.javacrud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());

        if(userOptional.isPresent()) {
            throw new IllegalStateException("Email " + user.getEmail() + " already exists");
        }

        userRepository.save(user);
    }


    public void updateUser(Long userId, User userDetails) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("The user with id " + userId + " does not exist"));

        if(userDetails.getName() != null && userDetails.getName().length() > 0 && !Objects.equals(user.getName(), userDetails.getName())) {
            user.setName(userDetails.getName());
        }

        if(userDetails.getEmail() != null && userDetails.getEmail().length() > 0 && !Objects.equals(user.getEmail(), userDetails.getEmail())) {
            Optional<User> userOptional = userRepository.findUserByEmail(userDetails.getEmail());

            if(userOptional.isPresent()) {
                throw new IllegalStateException("Email " + userDetails.getEmail() + " already taken.");
            }

            user.setEmail(userDetails.getEmail());
        }

        if(userDetails.getPhoneNumber() != null && userDetails.getPhoneNumber().startsWith("+") && !Objects.equals(user.getPhoneNumber(), userDetails.getPhoneNumber())) {
            user.setPhoneNumber(userDetails.getPhoneNumber());
        }

        userRepository.save(user);

    }


    public void deleteUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);

        if(userOptional.isEmpty()) {
            throw new IllegalStateException("The student with the given ID does not exist.");
        }

        userRepository.deleteById(userId);

    }
}
