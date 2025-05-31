package com.arthur.todolist.controllers.dtos.response;

public record UserResponseDTO(Long id, String userName, String email,String phone , String userType) {
}
