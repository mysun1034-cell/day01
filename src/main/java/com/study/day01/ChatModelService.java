package com.study.day01;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
public class ChatModelService {

    private final ChatModel chatModel;

    public ChatModelService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String chat(String message) {
        return chatModel.call(message);
    }
}