package com.arthur.todolist.repositorys;

import com.arthur.todolist.controllers.dtos.response.UserResponseDTO;

import com.arthur.todolist.domain.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface IUserRepository extends JpaRepository<Users,Long> {

    Optional<Users> findUsersByEmail(String email);

    Optional<Users> findUsersById(Long id);

}
