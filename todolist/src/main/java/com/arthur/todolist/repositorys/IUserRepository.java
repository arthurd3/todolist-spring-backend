package com.arthur.todolist.repositorys;

import com.arthur.todolist.domain.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<Users,Integer> {

    Optional<Users> getUserById(int id);
    Optional<Users> getUserByEmail(String email);
}
