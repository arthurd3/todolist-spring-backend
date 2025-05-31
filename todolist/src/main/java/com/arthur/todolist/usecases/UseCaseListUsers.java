package com.arthur.todolist.usecases;

import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.gateways.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UseCaseListUsers {

    private final UserGateway userGateway;

    public List<UserResponseDTO> listUsers() {
        return userGateway.findAllUsers();
    }
}
