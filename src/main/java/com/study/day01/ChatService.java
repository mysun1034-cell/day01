package com.study.day01;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    //일반응답
    public String chat(@RequestParam String message) {
        String content = chatClient.prompt()
                .user(message) // UserPrompt 사용자의 실제 질문
                .call()
                .content();

        return "[질문]" + message + "[응답본문]" + content;

    public String teacher(@RequestParam String message) {
        return chatClient.prompt()
                .system("""
                        당신은 Java, Springboot, SpringAI를 가르치는 
                        선생님입니다. 초보 학습자에게 설명하듯이 답변 해주세요.
                        핵심 개념, 예시, 주의할 점을 포함하여야 합니다.
                        친절하게 한국어로 설명해주세요.
                        """) //System Prompt 역할을 지시
                .user(message) // UserPrompt 사용자의 실제 질문
                .call()
                .content();
    }
}
