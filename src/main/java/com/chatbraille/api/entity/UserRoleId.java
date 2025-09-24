package com.chatbraille.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
public class UserRoleId implements Serializable {

    @Column(name = "user_seq", nullable = false)
    private Long userSeq;

    @Column(name = "role_seq", nullable = false)
    private Long roleSeq;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleId that = (UserRoleId) o;
        return Objects.equals(userSeq, that.userSeq) &&
               Objects.equals(roleSeq, that.roleSeq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userSeq, roleSeq);
    }
}