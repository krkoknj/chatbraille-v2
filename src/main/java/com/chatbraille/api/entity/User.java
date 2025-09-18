package com.chatbraille.api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_seq", nullable = false)
    private Long userSeq;

    @Column(name = "id", nullable = false, length = 50)
    private String id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "mod_dt")
    private LocalDateTime modDt;

    @Column(name = "mod_seq")
    private Long modSeq;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    // Getters and setters...
}