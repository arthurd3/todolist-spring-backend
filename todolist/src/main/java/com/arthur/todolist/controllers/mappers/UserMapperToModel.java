package com.arthur.todolist.controllers.mappers;

import com.arthur.todolist.controllers.dtos.request.UserRequestDTO;
import com.arthur.todolist.domain.User;
import com.arthur.todolist.domain.entities.UserType;

public class UserMapperToModel {
    public User userRequestModel(UserRequestDTO userRequest , UserType userType) {
        return new User(userRequest.userName() ,userRequest.email(), userRequest.phone(), userRequest.password() , userType);
    }
}
