package com.example.authservice.service;

import com.example.authservice.entity.UserAuthDetails;
import com.example.authservice.repository.UserDetailsRepository;
import com.example.authservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public String saveUser(UserAuthDetails userAuthDetails){
        userAuthDetails.setPassword(passwordEncoder.encode(userAuthDetails.getPassword()));
        userDetailsRepository.save(userAuthDetails);
        return "User added to the system" + userAuthDetails.getId();
    }


    public String generateToken(String username) {
        return jwtUtil.generateToken(username);
    }

    public void validateToken(String token) {
        jwtUtil.validateToken(token);
    }
}
