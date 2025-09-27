package com.chatbraille.api.respository;

import com.chatbraille.api.entity.User;
import java.util.List;

/**
 * Custom repository interface for {@link User} entity.
 *
 * <p>Declares custom query methods implemented using Querydsl. Extend this
 * interface in your {@link UserRepository} to expose additional query
 * operations beyond those provided by {@link org.springframework.data.jpa.repository.JpaRepository}.
 */
public interface UserRepositoryCustom {

    /**
     * Returns all users that are active and not marked as deleted.
     *
     * @return a list of active, non-deleted users
     */
    List<User> findActiveUsers();
}