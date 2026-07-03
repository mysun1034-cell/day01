package com.study.day02promptoutput;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class PromptService {

    private final ChatClient chatClient;

    public PromptService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultSystem("""
                    당신은 온라인 쇼핑몰 고객센터의 AI 어시스턴트입니다.
                    항상 정중한 한국어로 답변하고, 확실하지 않은 내용은 추측하지 않습니다.
                    """)
                .build();
    }

    public String summarize(String text, String audience) {
        return chatClient.prompt()
                .user(u -> u.text("""
                        다음 문의 내용을 {audience}가 이해하기 쉽게 3줄 이내로 요약해주세요.
                        전달 목적이 무엇인지 첫 줄에 먼저 적어주세요.
                        문의 내용:
                        {text}
                        """)
                        .param("audience", audience)
                        .param("text", text))
                .call()
                .content();
    }
}