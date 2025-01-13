package com.example.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String username;
    private String role;
    private LocalDateTime createdDate;

    // Getters and Setters
}
