package com.arthur.todolist.usecases;

import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.gateways.UserGateway;
import com.arthur.todolist.gateways.mappers.UserMapperToResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UseCaseFindUser {

    final UserGateway userGateway;
    final UserMapperToResponse userMapperToResponse;

    public Optional<UserResponseDTO> findUser(Long id) {
        return userMapperToResponse.userModelResponse(userGateway.findUserById(id).get());
    }
}
