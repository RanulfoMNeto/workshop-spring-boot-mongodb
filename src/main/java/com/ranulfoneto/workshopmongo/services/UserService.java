package com.ranulfoneto.workshopmongo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ranulfoneto.workshopmongo.domain.User;
import com.ranulfoneto.workshopmongo.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<User> findAll() {
        return userRepository.findAll();
    }

}
