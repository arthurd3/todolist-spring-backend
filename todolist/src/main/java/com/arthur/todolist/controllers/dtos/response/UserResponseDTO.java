package com.arthur.todolist.controllers.dtos.response;

import com.arthur.todolist.domain.enums.UserType;

public record UserResponseDTO(Long id, String userName, String email, String phone , UserType userType) {
}
