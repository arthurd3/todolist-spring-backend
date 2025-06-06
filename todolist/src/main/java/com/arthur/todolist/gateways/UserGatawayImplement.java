package com.arthur.todolist.gateways;

import com.arthur.todolist.controllers.dtos.request.UserRequestDTO;
import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;
import com.arthur.todolist.domain.entities.Users;
import com.arthur.todolist.domain.enums.UserType;
import com.arthur.todolist.gateways.mappers.UserMapperToModel;
import com.arthur.todolist.gateways.mappers.UserMapperToResponse;
import com.arthur.todolist.repositorys.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserGatawayImplement implements UserGateway {
    private final IUserRepository userRepository;
    private final UserMapperToResponse userMapperToResponse;
    private final UserMapperToModel userMapperToModel;
    @Override
    public Optional<UserResponseDTO> registerUser(UserRequestDTO user) {

        UserType userType = UserType.CLIENT;
        var userSave = userMapperToModel.userRequestModel(user , userType);
        userRepository.save(userSave);

        return userMapperToResponse.userModelResponse(userSave);
    }

    @Override
    public Optional<UserResponseDTO> editUser(UserRequestDTO userRequestDTO) {

        var editUser = userMapperToModel.userRequestModel(userRequestDTO , userRequestDTO.userType());
        var realUser = userRepository.findById(userRequestDTO.id()).get();

        BeanUtils.copyProperties(editUser, realUser);

        userRepository.save(realUser);

        return userMapperToResponse.userModelResponse(realUser);
    }

    @Override
    public Optional<UserResponseDTO> findUserByEmail(String email) {
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

    @Override
    public List<UserResponseDTO> findAllUsers() {
        List<UserResponseDTO> listUsers = userRepository.findAll()
                .stream()
                .map(users -> userMapperToResponse.userModelResponse(users).get())
                .collect(Collectors.toList());

        return listUsers;
    }
}
