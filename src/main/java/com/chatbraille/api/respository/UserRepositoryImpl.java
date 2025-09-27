package com.chatbraille.api.respository;

import com.chatbraille.api.entity.QUser;
import com.chatbraille.api.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * Implementation of {@link UserRepositoryCustom} using Querydsl.
 */
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> findActiveUsers() {
        QUser user = QUser.user;
        return queryFactory
                .selectFrom(user)
                .where(user.isActive.eq(true)
                        .and(user.isDeleted.eq(false)))
                .fetch();
    }
}