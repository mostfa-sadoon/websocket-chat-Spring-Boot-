package com.sadoon.chat.service.imp;


import com.sadoon.chat.model.entity.User;
import com.sadoon.chat.repository.UserRepository;
import com.sadoon.chat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

  public  Long getUserId(){
      String username = SecurityContextHolder.getContext().getAuthentication().getName();
      Optional<User> user = userRepository.findByUsername(username);
      return user.get().getId();
  }
}
