package com.arthur.todolist.repositorys;

import com.arthur.todolist.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User,Integer> {

    public Optional<User> getUserById(int id);
    public Optional<User> getUserByEmail(String email);
}
