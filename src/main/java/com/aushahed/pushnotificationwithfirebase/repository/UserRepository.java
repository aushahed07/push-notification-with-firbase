package com.aushahed.pushnotificationwithfirebase.repository;

import com.aushahed.pushnotificationwithfirebase.schema.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> getByUserId(Long userId);
}
