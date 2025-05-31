package com.arthur.todolist.gateways.mappers;

import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.domain.entities.Users;

import java.util.Optional;

public class UserMapperToResponse {
    public Optional<UserResponseDTO> userModelResponse(Users users) {
        var convertUser = new UserResponseDTO(users.getId() , users.getUserName() , users.getEmail(), users.getPhone(), users.getUserType());
        return Optional.of(convertUser);
    }
}
