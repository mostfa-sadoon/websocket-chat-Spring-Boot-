package com.sadoon.chat.controller;


import com.sadoon.chat.model.dto.req.MessageDto;
import com.sadoon.chat.model.entity.Chat;
import com.sadoon.chat.model.entity.ChatUser;
import com.sadoon.chat.model.entity.Message;
import com.sadoon.chat.model.mapper.MessageMapper;
import com.sadoon.chat.repository.ChatRepository;
import com.sadoon.chat.repository.ChatUserRepository;
import com.sadoon.chat.service.UserService;
import com.sadoon.chat.service.imp.ChatServiceImp;
import com.sadoon.chat.service.imp.MessageServiceImp;
import com.sadoon.chat.service.imp.UserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@Slf4j
public class ChatController {

    @Autowired
    ChatServiceImp chatService;

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    MessageServiceImp messageServiceImp;

    @Autowired
    UserServiceImp userServiceImp;


    @GetMapping("/chat")
    public  String index(Model model){
        List<Chat> chats = chatService.getChatsForCurrentUser();
        model.addAttribute("chats",chats);
        model.addAttribute("currentUserId",userServiceImp.getUserId());
        return "chat";
    }

    @MessageMapping("sendMessage")
    @SendTo("/topic/messages")
    public MessageDto save(@RequestBody MessageDto dto ){
        log.info("dto is :{}",dto);
        Message message=  messageMapper.MessageDtoToEntity(dto);
        messageServiceImp.save(message);
        return  dto;
    }


    @PostMapping("send")
    public String saveMessage(@RequestBody MessageDto dto ,Model model){
        log.info("dto is :{}",dto);
        Message message=  messageMapper.MessageDtoToEntity(dto);
        messageServiceImp.save(message);


        model.addAttribute("chat",chatRepository.findById(dto.getChat_id()).get());
        model.addAttribute("currentUserId",userServiceImp.getUserId());


        return "messages";
    }
}
