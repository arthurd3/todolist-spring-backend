package com.arthur.todolist.config.beans;

import com.arthur.todolist.controllers.mappers.UserMapperToModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public UserMapperToModel userMapper() {
        return new UserMapperToModel();
    }


}
