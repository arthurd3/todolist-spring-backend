package com.arthur.todolist.usecases.mappers;

import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.domain.entities.Users;

public class UserMapperToResponse {
    public UserResponseDTO userModelResponse(Users users) {
        return new UserResponseDTO(users.getId() , users.getUsername() , users.getEmail(), users.getPhone(), users.getUserType().toString());
    }
}
