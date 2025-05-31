package com.arthur.todolist.controllers;

import com.arthur.todolist.controllers.dtos.request.UserRequestDTO;
import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.gateways.mappers.UserMapperToModel;
import com.arthur.todolist.usecases.*;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UseCaseRegisterUser useCaseRegisterUser;
    private final UseCaseDeleteUser useCaseDeleteUser;
    private final UseCaseEditUser useCaseEditUser;
    private final UseCaseListUsers useCaseListUsers;
    private final UseCaseFindUser useCaseFindUser;

    @PostMapping("/registerUser")
    public Optional<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequest) {
        return useCaseRegisterUser.registerUser(userRequest);
    }

    @DeleteMapping("/deleteUser/{id}")
    public Optional<UserResponseDTO> createUser(@PathVariable(name = "id") Long id) {
        return useCaseDeleteUser.deleteUser(id);
    }

    @PutMapping("/editUser")
    public Optional<UserResponseDTO> editUser(@RequestBody UserRequestDTO userRequest) {
        return useCaseEditUser.editUser(userRequest);
    }

    @GetMapping("/listUsers")
    public List<UserResponseDTO> listUsers() {
        return useCaseListUsers.listUsers();
    }

    @GetMapping("/findUser/{id}")
    public Optional<UserResponseDTO> findUser(@PathVariable(name = "id") Long id) {
        return useCaseFindUser.findUser(id);
    }
}
