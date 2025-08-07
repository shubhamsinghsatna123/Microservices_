package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserData;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserData, String> {
    Optional<UserData> findByEmailIgnoreCase(String email);
    Optional<UserData> findByMobile(Long mobile);
}
