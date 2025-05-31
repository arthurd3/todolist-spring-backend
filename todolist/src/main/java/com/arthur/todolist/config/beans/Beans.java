package com.arthur.todolist.config.beans;

import com.arthur.todolist.controllers.mappers.UserMapperToModel;

import com.arthur.todolist.usecases.mappers.UserMapperToResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public UserMapperToModel userMapper() {
        return new UserMapperToModel();
    }

    @Bean
    public UserMapperToResponse userMapperResponse() {
        return new UserMapperToResponse();
    }
}
