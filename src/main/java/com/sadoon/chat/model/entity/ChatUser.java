package com.sadoon.chat.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ChatUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference("user-chat")
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "chat_user")
    )
    private User user;

    @ManyToOne
    @JsonBackReference("chat-user")
    @JoinColumn(
            name = "chat_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "chat_user")
    )
    private Chat chat;

}
