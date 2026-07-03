package com.study.day02promptoutput;

import com.study.day02promptoutput.dto.InquiryResult;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.SplittableRandom;

@Service
public class ClassifyService {

    private static final String CLASSIFY_TEMPLATE = """
            다음 고객 문의를 분류해주세요.

            - category: 배송, 환불, 상품, 계정, 기타 중 하나
            - priority: HIGH, MEDIUM, LOW 중 하나
            - reason: 그렇게 분류한 이유 한 문장

            문의 내용: {text}
            """;

    private final ChatClient chatClient;

    public ClassifyService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String classify(String text) {
        return chatClient.prompt()
                .user(u -> u.text(CLASSIFY_TEMPLATE)
                        .param("text", text))
                .call()
                .content();
    }

    public String classifyJson(String text) {
        return chatClient.prompt()
                .user(u -> u.text("""
                                다음 고객 문의를 분류해서 category, priority, reason
                                세 가지 필드를 가진 JSON으로 답하시오.

                                고객 문의: {text}
                                """)
                        .param("text", text))
                .call()
                .content();
    }

    public InquiryResult classifyObject(String text) {
        return chatClient.prompt()
                .user(u -> u.text(CLASSIFY_TEMPLATE)
                        .param("text", text))
                .call()
                .entity(InquiryResult.class);
    }

    //여러개 개체 목록으로 담아 만들기
    public List<MovieResponse> recommendMovies(String mood) {
        return chatClient.prompt()
                .user(u -> u.text("""
                                {mood} 기분에 어울리는 영화 3개를 추천해주세요.
                                각 영화는 title, genre, reason 필드를 포함해서 답해주세요.
                                """)
                        .param("mood", mood))
                .call()
                .entity(new ParameterizedTypeReference<List<MovieResponse>>() {
                });
    }

    //단순한 문자열의 리스트 담기
    public List<String> packingList(String destination, int days) {
        return chatClient.prompt()
                .user(u -> u.text("""
                    {destination}으로 {days}일 동안 여행 갈 때 필요한 준비물을
                    문자열 배열 형태로 추천해주세요.
                    """)
                        .param("destination", destination)
                        .param("days", days))
                .call()
                .entity(new ParameterizedTypeReference<List<String>>() {
                });
    }


}
