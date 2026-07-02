package com.study.day01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Rest API 방식의 컨트롤러
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/api/chat")
    public String chat(@RequestParam String message) {
        return chatService.chat(message);
    }

    @GetMapping("/api/teacher")
    public String teacher(@RequestParam String message) {
        return chatService.teacher(message);
    }

    @GetMapping("/api/safe-chat")
    public String safeChat(@RequestParam String message) {
        return chatService.safeChat(message);
    }

    @GetMapping("/api/code-explain")
    public String codeExplain(@RequestParam String message) {
        return chatService.codeExplain(message);
    }

    @GetMapping("/api/interview-questions")
    public String interviewQuestions(@RequestParam String message) {
        return chatService.interviewQuestions(message);
    }
}
