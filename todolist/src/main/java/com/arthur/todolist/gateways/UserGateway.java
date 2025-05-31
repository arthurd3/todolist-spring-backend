package com.arthur.todolist.gateways;
import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.domain.entities.Users;


import java.util.Optional;

public interface UserGateway {
    Optional<UserResponseDTO> registerUser(Users user);
    Optional<Users> getUserByEmail(String email);
}
