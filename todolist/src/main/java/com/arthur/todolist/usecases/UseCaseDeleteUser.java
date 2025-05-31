package com.arthur.todolist.usecases;

import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.gateways.UserGateway;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UseCaseDeleteUser {

    private final UserGateway userGateway;
    @Transactional
    public Optional<UserResponseDTO> deleteUser(Long id) {

        if(userGateway.findUserById(id).isPresent())
            return userGateway.deleteUserById(id);

        return Optional.empty();

    }

}
