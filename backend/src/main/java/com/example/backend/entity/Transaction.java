package com.example.backend.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "accountNumber", nullable = false)
    private Account account;

    private String type;
    private Double amount;
    private LocalDateTime timestamp;
    private String description;

    // Getters and Setters
}
