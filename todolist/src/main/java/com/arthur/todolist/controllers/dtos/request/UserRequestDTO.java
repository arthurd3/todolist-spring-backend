package com.arthur.todolist.controllers.dtos.request;

import com.arthur.todolist.domain.enums.UserType;

public record UserRequestDTO (Long id , String userName, String email, String password , String phone , UserType userType) {
}
