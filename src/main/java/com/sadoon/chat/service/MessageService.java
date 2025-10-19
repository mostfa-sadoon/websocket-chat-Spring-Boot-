package com.sadoon.chat.service;

import com.sadoon.chat.model.dto.req.MessageDto;
import com.sadoon.chat.model.entity.Message;

public interface MessageService {
    Message save(Message entity);
}
