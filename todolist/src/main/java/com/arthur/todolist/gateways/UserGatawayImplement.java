package com.arthur.todolist.gateways;

import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.domain.entities.Users;
import com.arthur.todolist.gateways.mappers.UserMapperToResponse;
import com.arthur.todolist.repositorys.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserGatawayImplement implements UserGateway {
    private final IUserRepository userRepository;
    private final UserMapperToResponse userMapperToResponse;

    @Override
    public Optional<UserResponseDTO> registerUser(Users user) {
        return userMapperToResponse.userModelResponse(userRepository.save(user));
    }

    @Override
    public Optional<Users> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
