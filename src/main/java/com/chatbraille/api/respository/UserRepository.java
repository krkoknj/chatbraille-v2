package com.chatbraille.api.respository;

import com.chatbraille.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for {@link User} entities.
 *
 * <p>This interface extends {@link JpaRepository} to inherit standard CRUD
 * operations and {@link UserRepositoryCustom} to include Querydsl-based
 * custom queries.</p>
 */
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}