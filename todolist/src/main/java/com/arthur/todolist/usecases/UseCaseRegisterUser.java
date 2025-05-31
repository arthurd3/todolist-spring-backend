package com.arthur.todolist.usecases;

import com.arthur.todolist.controllers.dtos.request.UserRequestDTO;
import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;

import com.arthur.todolist.domain.enums.UserType;
import com.arthur.todolist.gateways.UserGateway;
import com.arthur.todolist.gateways.mappers.UserMapperToModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UseCaseRegisterUser {

    private final UserGateway userGateway;
    private final UserMapperToModel userMapperToModel;

    public Optional<UserResponseDTO> registerUser(UserRequestDTO userRequest) {

        UserType userType = UserType.CLIENT;
        var user = userMapperToModel.userRequestModel(userRequest , userType);

        var existsUser = userGateway.getUserByEmail(user.getEmail());

        if(existsUser.isPresent()) {
            return Optional.empty();
        }

        return userGateway.registerUser(user);
    }
}
