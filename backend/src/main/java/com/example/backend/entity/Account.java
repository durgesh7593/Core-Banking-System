package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Account {

    @Id
    private String accountNumber;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    private String accountType;
    private Double balance;

    private LocalDateTime createdDate;

    // Getters and Setters
}
