package com.study.day01;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    // 일반 응답
    public String chat(String message) {
        String content = chatClient.prompt()
                .user(message)
                .call()
                .content();

        return "[질문]" + message + "[응답본문]" + content;
    }

    // 선생님 역할 응답
    public String teacher(String message) {
        return chatClient.prompt()
                .system("""
                        당신은 Java, Spring Boot, Spring AI를 가르치는 선생님입니다.
                        초보 학습자에게 설명하듯이 답변해주세요.
                        핵심 개념, 예시, 주의할 점을 포함해야 합니다.
                        친절하게 한국어로 설명해주세요.
                        """)
                .user(message)
                .call()
                .content();
    }

    // 기준을 강화한 낮은 temperature 응답
    public String safeChat(String message) {
        return chatClient.prompt()
                .user(message)
                .options(GoogleGenAiChatOptions.builder()
                        .temperature(0.2))
                .call()
                .content();
    }

    // 미니 실습 1: 코드 설명 도우미
    public String codeExplain(String code) {
        return chatClient.prompt()
                .system("""
                        당신은 Java와 Spring Boot 코드를 설명하는 코드 리뷰 선생님입니다.
                        초보자가 이해할 수 있도록 코드의 목적, 실행 흐름, 핵심 문법, 주의할 점을 나누어 설명해주세요.
                        답변은 한국어로 작성하고, 필요하면 짧은 예시를 포함해주세요.
                        """)
                .user(code)
                .call()
                .content();
    }

    // 미니 실습 2: 면접 질문 생성기
    public String interviewQuestions(String techStack) {
        return chatClient.prompt()
                .system("""
                        당신은 신입 개발자 면접을 준비시키는 면접 코치입니다.
                        입력받은 기술 스택을 바탕으로 예상 면접 질문 7개와 각 질문의 답변 방향을 만들어주세요.
                        난이도는 입문자에게 맞추고, 답변은 한국어로 작성해주세요.
                        """)
                .user(techStack)
                .call()
                .content();
    }
}
