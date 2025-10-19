package com.sadoon.chat.repository;

import com.sadoon.chat.model.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository <Chat , Long> {

    @Query("SELECT DISTINCT c FROM Chat c JOIN c.chatUsers cu WHERE cu.user.id = :userId")
    List<Chat> findAllByUserId(@Param("userId") Long userId);

}

