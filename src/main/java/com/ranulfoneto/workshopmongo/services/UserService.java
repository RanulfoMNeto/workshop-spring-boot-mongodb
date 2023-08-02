package com.ranulfoneto.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ranulfoneto.workshopmongo.dtos.AuthorDTO;
import com.ranulfoneto.workshopmongo.dtos.UserDTO;
import com.ranulfoneto.workshopmongo.models.User;
import com.ranulfoneto.workshopmongo.repositories.UserRepository;
import com.ranulfoneto.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void delete(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.id(), userDTO.name(), userDTO.email());
    }

    public UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public AuthorDTO toAuthorDTO(User user) {
        return new AuthorDTO(user.getId(), user.getName());
    }

    public User update(User user) {
        User newUser = findById(user.getId());
        updateData(newUser, user);
        return userRepository.save(newUser);
    }

    private void updateData(User newUser, User user) {
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
    }

}
