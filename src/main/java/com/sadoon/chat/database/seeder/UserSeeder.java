package com.sadoon.chat.database.seeder;

import com.sadoon.chat.model.entity.User;
import com.sadoon.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserSeeder implements CommandLineRunner {

  @Autowired
    UserRepository userRepository;

  @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public  void run(String... args){
        if (userRepository.count() == 0) {
            User user = new User();
            user.setName("Mostafa Saadoun");
            user.setUsername("mostfa_sadoon");
            user.setEmail("sadoonmostfa6@gmail.com");
            user.setPassword(this.passwordEncoder.encode("123456"));
//            admin.setRoles(Set.of("ADMIN"));
            userRepository.save(user);

            User user2 = new User();
            user2.setName("Mo Saadoun");
            user2.setUsername("mo_sadoon");
            user2.setEmail("mosalah@gmail.com");
            user2.setPassword(this.passwordEncoder.encode("123456"));

            userRepository.save(user2);

            User user3 = new User();
            user3.setName("MoHamed Saadoun");
            user3.setUsername("mohamed_sadoon");
            user3.setEmail("mohamed@gmail.com");
            user3.setPassword(this.passwordEncoder.encode("123456"));

            userRepository.save(user3);

            System.out.println("✅ Admin user seeded successfully!");
        }
    }



}
