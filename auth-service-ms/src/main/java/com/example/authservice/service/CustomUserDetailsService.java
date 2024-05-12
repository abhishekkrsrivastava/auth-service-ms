package com.example.authservice.service;

import com.example.authservice.entity.UserAuthDetails;
import com.example.authservice.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Optional<UserAuthDetails> userDetails = userDetailsRepository.findByName(username);
      return userDetails.map(CustomUserDetails::new)
              .orElseThrow(() -> new UsernameNotFoundException("user not found "));

    }
}
