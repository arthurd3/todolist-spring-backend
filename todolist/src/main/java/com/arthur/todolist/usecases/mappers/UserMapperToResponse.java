package com.arthur.todolist.usecases.mappers;

import com.arthur.todolist.controllers.dtos.request.UserRequestDTO;
import com.arthur.todolist.domain.User;
import com.arthur.todolist.domain.entities.UserType;

public class UserMapperToResponse {
    public User userModelResponse(UserRequestDTO userRequest , UserType userType) {
        return new User(userRequest.userName() ,userRequest.email(), userRequest.phone(), userRequest.password() , userType);
    }
}
