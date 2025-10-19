package com.sadoon.chat.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @OneToMany(mappedBy = "chat")
    @JsonManagedReference("chat-received")
    private List<Message> receivedMessages;


    @OneToMany(mappedBy = "chat")
    @JsonManagedReference("chat-user")
    private List<ChatUser> chatUsers;
}
