package com.study.day02promptoutput;

import com.study.day02promptoutput.dto.InquiryResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassifyController {

    private final ClassifyService classifyService;

    public ClassifyController(ClassifyService classifyService) {
        this.classifyService = classifyService;
    }

    @GetMapping("/api/classify")
    public String classify(@RequestParam String text) {
        return classifyService.classify(text);
    }

    @GetMapping("/api/classify/json")
    public String classifyJson(@RequestParam String text) {
        return classifyService.classifyJson(text);
    }

    @GetMapping("/api/classify/object")
    public InquiryResult classifyObject(@RequestParam String text) {
        return classifyService.classifyObject(text);
    }

    @GetMapping("/api/movie")
    public List<MovieResponse> movie(@RequestParam String mood) {
        return classifyService.recommendMovies(mood);
    }

    @GetMapping("/api/packing")
    public List<String> packing(@RequestParam String destination, @RequestParam(defaultValue = "3") int days) {
        return classifyService.packingList(destination, days);
    }
}
