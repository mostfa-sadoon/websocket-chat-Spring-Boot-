package com.sadoon.chat.model.mapper;

import com.sadoon.chat.model.dto.req.MessageDto;
import com.sadoon.chat.model.entity.Chat;
import com.sadoon.chat.model.entity.Message;
import com.sadoon.chat.model.entity.User;
import com.sadoon.chat.repository.ChatRepository;
import com.sadoon.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageMapper {

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    UserRepository userRepository;

    public  Message MessageDtoToEntity(MessageDto dto){
        Optional<Chat> chat  = chatRepository.findById(dto.getChat_id());
        Optional<User>   sender =userRepository.findById(dto.getSender_id());
        Optional<User>    reciver =userRepository.findById(dto.getReciver_id());



        Message message = new Message();
        message.setBody(dto.getBody());
        message.setChat(chat.get());
        message.setSender(sender.get());
        message.setReceiver(reciver.get());
        return  message;
    }
}
