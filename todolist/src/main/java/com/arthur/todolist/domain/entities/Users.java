package com.arthur.todolist.domain.entities;

import com.arthur.todolist.domain.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true , nullable = false  ,name = "username")
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(unique = true , nullable = false)
    private String email;

    @Column(unique = true , nullable = false)
    private String phone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public Users(String userName, String password, String email, String phone , UserType userType )
    {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.userType = userType;
    }
}
