package com.chldudgh.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor //생성자 주입
@RestController //rest api 컨트롤러. 자동으로 json응답
public class ProfileController {
    private final Environment env;

    @GetMapping("/profile")
    public String profile() {
        //실행중인 ActiveProfile을 가져옴. real, oauth. real-db
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        List<String> realProfiles = Arrays.asList("real", "real1", "real2");
        String defaultProfile = profiles.isEmpty()? "default": profiles.get(0);
        return profiles.stream()
                .filter(realProfiles::contains)
                .findAny()
                .orElse(defaultProfile);
    }
}
