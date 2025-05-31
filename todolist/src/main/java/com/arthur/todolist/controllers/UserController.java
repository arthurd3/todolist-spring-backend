package com.arthur.todolist.controllers;

import com.arthur.todolist.controllers.dtos.request.UserRequestDTO;
import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.controllers.mappers.UserMapperToModel;
import com.arthur.todolist.domain.enums.UserType;
import com.arthur.todolist.usecases.UseCaseRegisterUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserMapperToModel userMapperToModel;
    private final UseCaseRegisterUser useCaseRegisterUser;

    @PostMapping("/registerUser")
    public Optional<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequest) {
        UserType userType = UserType.CLIENT;
        var user = userMapperToModel.userRequestModel(userRequest , userType);
        return useCaseRegisterUser.registerUser(user);
    }
}
