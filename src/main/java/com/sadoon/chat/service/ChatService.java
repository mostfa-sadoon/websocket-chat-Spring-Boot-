package com.sadoon.chat.service;

import com.sadoon.chat.model.entity.Chat;

import java.util.List;

public interface ChatService {
    List<Chat>  getChatsForCurrentUser();

}
