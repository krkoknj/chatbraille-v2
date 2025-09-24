package com.chatbraille.api.respository;

import com.chatbraille.api.entity.UserRole;
import com.chatbraille.api.entity.UserRoleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {}