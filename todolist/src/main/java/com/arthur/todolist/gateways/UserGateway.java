package com.arthur.todolist.gateways;
import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.domain.entities.Users;

import java.util.Optional;

public interface UserGateway {
    Optional<UserResponseDTO> registerUser(Users user);
    Optional<UserResponseDTO> getUserByEmail(String email);
    Optional<UserResponseDTO> deleteUserById(Long id);
    Optional<UserResponseDTO> findUserById(Long id);
}
