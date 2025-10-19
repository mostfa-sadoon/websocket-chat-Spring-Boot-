package com.sadoon.chat.model.dto.req;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {

  private  String  body;
  private  Long    sender_id;
  private  Long    reciver_id;
  private  Long    chat_id;
}
