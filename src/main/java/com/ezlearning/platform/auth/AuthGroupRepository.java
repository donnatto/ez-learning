package com.ezlearning.platform.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {
    List<AuthGroup> findByUsername(String username);
}
