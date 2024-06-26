package com.saffron.oauth2.repo;

import com.saffron.oauth2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

//@NoRepositoryBean
public interface UserJpaRepo extends JpaRepository<User, Long> {
    Optional<User> findByUid(String email);
}
