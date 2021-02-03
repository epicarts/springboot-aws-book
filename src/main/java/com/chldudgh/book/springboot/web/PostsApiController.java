package com.chldudgh.book.springboot.web;

import com.chldudgh.book.springboot.service.posts.PostsService;
import com.chldudgh.book.springboot.web.dto.PostsResponseDto;
import com.chldudgh.book.springboot.web.dto.PostsSaveRequestDto;
import com.chldudgh.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestsDto) {
        return postsService.save(requestsDto); //서비스 레이어의 save 메서드 호출
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        //uri에서 가져온 id와
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
