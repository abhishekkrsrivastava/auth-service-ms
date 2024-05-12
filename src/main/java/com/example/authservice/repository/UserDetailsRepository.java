package com.example.authservice.repository;

import com.example.authservice.entity.UserAuthDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<UserAuthDetails, Integer> {




    Optional<UserAuthDetails> findByName(String username);
}
