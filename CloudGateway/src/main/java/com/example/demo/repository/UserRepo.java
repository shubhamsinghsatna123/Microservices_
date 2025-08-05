package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserData;

@Repository
public interface UserRepo extends JpaRepository<UserData, String> {

	Optional<UserData> findByEmailIgnoreCase(String email);

	Optional<UserData> findByMobile(Long mobile);


}
