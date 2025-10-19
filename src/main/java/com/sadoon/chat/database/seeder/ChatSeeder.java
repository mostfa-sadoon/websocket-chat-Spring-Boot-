package com.sadoon.chat.database.seeder;

import com.sadoon.chat.model.entity.Chat;
import com.sadoon.chat.model.entity.ChatUser;
import com.sadoon.chat.model.entity.User;
import com.sadoon.chat.repository.ChatRepository;
import com.sadoon.chat.repository.ChatUserRepository;
import com.sadoon.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class ChatSeeder implements CommandLineRunner {

 @Autowired
 ChatRepository chatRepository;

 @Autowired
 UserRepository userRepository;

 @Autowired
 ChatUserRepository chatUserRepository;

    @Override
    public  void run(String... args) {
        if (chatRepository.count() == 0) {

            Optional<User> user1 = userRepository.findByUsername("mostfa_sadoon");
            Optional<User> user2 = userRepository.findByUsername("mo_sadoon");
            Chat chat = new Chat();
            Chat chatentity =  chatRepository.save(chat);
            if (user1.isPresent() && user2.isPresent()) {

                ChatUser chatUser1 = new ChatUser();
                chatUser1.setChat(chatentity);
                chatUser1.setUser(user1.get());
                chatUserRepository.save(chatUser1);

                ChatUser chatUser2 = new ChatUser();
                chatUser2.setChat(chatentity);
                chatUser2.setUser(user2.get());
                chatUserRepository.save(chatUser2);

            }
            System.out.println("✅ Chat seeded successfully!");
        }
    }
}
