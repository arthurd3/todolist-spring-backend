package com.arthur.todolist.usecases;


import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.controllers.mappers.UserMapperToModel;
import com.arthur.todolist.domain.User;
import com.arthur.todolist.gateways.UserGateway;
import com.arthur.todolist.repositorys.IUserRepository;

import java.util.Optional;

public class UserUseCase implements UserGateway {

    private final IUserRepository userRepository;
    private final UserMapperToModel userMapperToModel;
    public UserUseCase(IUserRepository userRepository , UserMapperToModel userMapperToModel) {
        this.userRepository = userRepository;
        this.userMapperToModel = userMapperToModel;
    }


    @Override
    public Optional<UserResponseDTO> registerUser(User user) {
        var existsUser = userRepository.getUserByEmail(user.getEmail());
        if(existsUser.isPresent()) {
            return Optional.empty();
        }

        var savedUser = userMapperToModel.userRepository.save(user);
        return Optional.of();
    }
}
