package com.study.day02promptoutput;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromptController {

    private final PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    @GetMapping("/api/summary")
    public String summary(@RequestParam String text, @RequestParam(defaultValue = "상담팀장") String audience) {
        return promptService.summarize(text, audience);
    }

}
