package com.sadoon.chat.service.imp;


import com.sadoon.chat.model.entity.Chat;
import com.sadoon.chat.model.entity.User;
import com.sadoon.chat.repository.ChatRepository;
import com.sadoon.chat.repository.UserRepository;
import com.sadoon.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImp implements ChatService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatRepository chatRepository;

    public List<Chat> getChatsForCurrentUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername(username);
        return chatRepository.findAllByUserId(user.get().getId());
    }
}
