package com.example.aerospikespringboot.services;

import com.example.aerospikespringboot.objects.User;
import com.example.aerospikespringboot.repositories.AerospikeUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {
    private final AerospikeUserRepository userRepository;


    public Optional<User> readUserById(Integer id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}
