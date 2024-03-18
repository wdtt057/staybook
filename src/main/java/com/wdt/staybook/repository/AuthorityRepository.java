package com.wdt.staybook.repository;

import com.wdt.staybook.entity.Authority;
import com.wdt.staybook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
    Optional<User> findByUsername();
}
