package com.arthur.todolist.gateways;
import com.arthur.todolist.controllers.dtos.request.UserRequestDTO;
import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.domain.entities.Users;

import java.util.List;
import java.util.Optional;

public interface UserGateway {
    Optional<UserResponseDTO> registerUser(Users user);
    Optional<UserResponseDTO> editUser(UserRequestDTO userRequestDTO);
    Optional<Users> getUserByEmail(String email);
    Optional<UserResponseDTO> deleteUserById(Long id);
    Optional<Users> findUserById(Long id);
    List<UserResponseDTO> findAllUsers();
}
