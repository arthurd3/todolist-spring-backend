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
    public Optional<UserResponseDTO> getUserByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }

    @Override
    public Optional<UserResponseDTO> deleteUserById(Long id) {
        var deletedUser = findUserById(id);
        userRepository.deleteById(id);
        if (findUserById(id).isPresent()) {
            return Optional.empty();
        }

        return deletedUser;
    }

    @Override
    public Optional<UserResponseDTO> findUserById(Long id) {
        return userRepository.findUsersById(id);
    }
}
