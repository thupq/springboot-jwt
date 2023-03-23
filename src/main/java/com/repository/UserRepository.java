package com.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.AppUser;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    boolean existsByUsername(String username);

    AppUser findByUsername(String username);

    @Transactional
    void deleteByUsername(String username);

    @Query("SELECT s FROM AppUser s WHERE s.username = :username AND s.status = :status")
    List<AppUser> findByUsernameActive(String username, Long status);

}
