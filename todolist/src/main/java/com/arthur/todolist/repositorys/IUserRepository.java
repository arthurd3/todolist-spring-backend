package com.arthur.todolist.repositorys;

import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;

import com.arthur.todolist.domain.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<Users,Long> {

    Optional<UserResponseDTO> findUsersByEmail(String email);

    Optional<UserResponseDTO> findUsersById(Long id);

    void deleteUsersById(Long id);
}
