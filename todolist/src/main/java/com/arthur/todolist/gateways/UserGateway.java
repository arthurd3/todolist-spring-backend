package com.arthur.todolist.gateways;

import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.domain.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserGateway {

    public Optional<UserResponseDTO> registerUser(User user);
}
