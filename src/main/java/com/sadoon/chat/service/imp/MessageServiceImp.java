package com.sadoon.chat.service.imp;

import com.sadoon.chat.model.dto.req.MessageDto;
import com.sadoon.chat.model.entity.Message;
import com.sadoon.chat.repository.MessageRepository;
import com.sadoon.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    public Message save(Message entity){
        return  messageRepository.save(entity);
    }
}
