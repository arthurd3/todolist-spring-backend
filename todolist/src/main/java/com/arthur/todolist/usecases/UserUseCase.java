package com.arthur.todolist.usecases;

import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.domain.entities.Users;

import com.arthur.todolist.gateways.UserGateway;
import com.arthur.todolist.repositorys.IUserRepository;
import com.arthur.todolist.usecases.mappers.UserMapperToResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserUseCase implements UserGateway {

    private final IUserRepository userRepository;
    private final UserMapperToResponse userMapperToResponse;

    public UserUseCase(IUserRepository userRepository , UserMapperToResponse userMapperToResponse) {
        this.userRepository = userRepository;
        this.userMapperToResponse = userMapperToResponse;
    }


    @Override
    public Optional<UserResponseDTO> registerUser(Users users) {
        var existsUser = userRepository.getUserByEmail(users.getEmail());

        if(existsUser.isPresent()) {
            return Optional.empty();
        }

        var savedUser = userMapperToResponse.userModelResponse(userRepository.save(users));
        return Optional.of(savedUser);
    }
}
