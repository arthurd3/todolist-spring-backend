package com.arthur.todolist.usecases;

import com.arthur.todolist.controllers.dtos.request.UserRequestDTO;
import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.gateways.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UseCaseEditUser {

    private final UserGateway userGateway;

    public Optional<UserResponseDTO> editUser(UserRequestDTO userRequestDTO) {
        return userGateway.editUser(userRequestDTO);
    }
}
