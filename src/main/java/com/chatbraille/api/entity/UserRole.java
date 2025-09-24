package com.chatbraille.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_role")
@Data
public class UserRole {

    @EmbeddedId
    private UserRoleId id;

    @ManyToOne
    @MapsId("userSeq")
    @JoinColumn(name = "user_seq")
    private User user;

    @ManyToOne
    @MapsId("roleSeq")
    @JoinColumn(name = "role_seq")
    private Role role;

    @Column(name = "mod_dt")
    private LocalDateTime modDt;

    @Column(name = "mod_seq")
    private Long modSeq;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

}