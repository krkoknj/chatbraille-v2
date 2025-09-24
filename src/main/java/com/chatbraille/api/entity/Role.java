package com.chatbraille.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_seq", nullable = false)
    private Long roleSeq;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "mod_dt")
    private LocalDateTime modDt;

    @Column(name = "mod_seq")
    private Long modSeq;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

}