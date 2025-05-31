package com.arthur.todolist.usecases;

import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.domain.entities.Users;

import com.arthur.todolist.gateways.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UseCaseRegisterUser {

    private final UserGateway userGateway;

    public Optional<UserResponseDTO> registerUser(Users user) {
        var existsUser = userGateway.getUserByEmail(user.getEmail());

        if(existsUser.isPresent()) {
            return Optional.empty();
        }

        return userGateway.registerUser(user);
    }
}
