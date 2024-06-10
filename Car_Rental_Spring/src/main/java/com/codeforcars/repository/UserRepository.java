package com.codeforcars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeforcars.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    Optional<User> findFirstByEmail(String email);
}
