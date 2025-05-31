package com.arthur.todolist.gateways;
import com.arthur.todolist.controllers.dtos.request.UserRequestDTO;
import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.domain.entities.Users;

import java.util.List;
import java.util.Optional;

public interface UserGateway {
    Optional<UserResponseDTO> registerUser(UserRequestDTO user);
    Optional<UserResponseDTO> editUser(UserRequestDTO userRequestDTO);
    Optional<UserResponseDTO> findUserByEmail(String email);
    Optional<UserResponseDTO> deleteUserById(Long id);
    Optional<UserResponseDTO> findUserById(Long id);
    List<UserResponseDTO> findAllUsers();
}
