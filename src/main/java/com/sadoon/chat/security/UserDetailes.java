package com.sadoon.chat.security;

import com.sadoon.chat.model.entity.User;
import com.sadoon.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailes implements UserDetailsService {

  @Autowired
    UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
      return org.springframework.security.core.userdetails.User
              .withUsername(user.getUsername())
              .password(user.getPassword())
             // .roles(user.getRoles().toArray(new String[0]))
              .build();

  }

}
