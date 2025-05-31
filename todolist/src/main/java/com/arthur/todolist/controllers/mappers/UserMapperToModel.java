package com.arthur.todolist.controllers.mappers;

import com.arthur.todolist.controllers.dtos.request.UserRequestDTO;
import com.arthur.todolist.domain.entities.Users;
import com.arthur.todolist.domain.enums.UserType;

public class UserMapperToModel {
    public Users userRequestModel(UserRequestDTO userRequest , UserType userType) {
        return new Users(userRequest.userName() ,userRequest.email(), userRequest.phone(), userRequest.password() , userType);
    }
}
