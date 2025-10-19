package com.sadoon.chat.model.entity;


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
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String name;
  private String email;
  private String password;

    @OneToMany(mappedBy = "sender")
    @JsonManagedReference("user-sent")
    private List<Message> sentMessages;


    @OneToMany(mappedBy = "receiver")
    @JsonManagedReference("user-received")
    private List<Message> receivedMessages;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference("user-chat")
    private List<ChatUser> chatUsers;
}
