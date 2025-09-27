package com.chatbraille.api;

import com.chatbraille.api.config.QuerydslConfig;
import com.chatbraille.api.entity.Role;
import com.chatbraille.api.entity.User;
import com.chatbraille.api.entity.UserRole;
import com.chatbraille.api.entity.UserRoleId;
import com.chatbraille.api.respository.RoleRepository;
import com.chatbraille.api.respository.UserRepository;
import com.chatbraille.api.respository.UserRoleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@Transactional
@Import(QuerydslConfig.class)
class UserRoleRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @DisplayName("User와 Role을 연결하고 복합키로 조회하는 테스트")
    @Test
    void testSaveAndFindUserRoleWithCompositeKey() {
        // 1. 초기 데이터 생성 (User)
        User user = new User();
        user.setId("testUser");
        user.setName("테스트사용자");
        user.setRegDt(LocalDateTime.now());
        user.setIsActive(true);
        user.setIsDeleted(false);
        user = userRepository.save(user);

        // 2. 초기 데이터 생성 (Role)
        Role role = new Role();
        role.setName("ADMIN");
        role.setIsDeleted(false);
        role = roleRepository.save(role);

        // 3. UserRole 복합키 생성 및 저장
        UserRoleId userRoleId = new UserRoleId();
        userRoleId.setUserSeq(user.getUserSeq());
        userRoleId.setRoleSeq(role.getRoleSeq());

        UserRole userRole = new UserRole();
        userRole.setId(userRoleId);
        userRole.setUser(user);
        userRole.setRole(role);
        userRole.setIsDeleted(false);
        userRole.setModDt(LocalDateTime.now());

        UserRole savedUserRole = userRoleRepository.save(userRole);

        // 4. 저장 확인 (NotNull 확인)
        assertThat(savedUserRole).isNotNull();

        // 5. 복합키를 이용한 조회 테스트
        Optional<UserRole> foundUserRole = userRoleRepository.findById(userRoleId);
        System.out.println("foundUserRole = " + foundUserRole);

        List<User> activeUsers = userRepository.findActiveUsers();
        System.out.println("activeUsers = " + activeUsers);

        // 6. 조회 결과 검증
        assertThat(foundUserRole).isPresent();
        assertThat(foundUserRole.get().getUser().getId()).isEqualTo("testUser");
        assertThat(foundUserRole.get().getRole().getName()).isEqualTo("ADMIN");
        assertThat(foundUserRole.get().getId().getUserSeq()).isEqualTo(user.getUserSeq());
    }
}