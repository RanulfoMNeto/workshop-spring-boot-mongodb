package com.ranulfoneto.workshopmongo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ranulfoneto.workshopmongo.dtos.UserDTO;
import com.ranulfoneto.workshopmongo.models.User;
import com.ranulfoneto.workshopmongo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = userService.findAll();
        List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x.getId(), x.getName(), x.getEmail())).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

}
