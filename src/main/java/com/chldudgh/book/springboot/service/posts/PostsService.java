package com.chldudgh.book.springboot.service.posts;

import com.chldudgh.book.springboot.domain.posts.Posts;
import com.chldudgh.book.springboot.domain.posts.PostsRepository;
import com.chldudgh.book.springboot.web.dto.PostsResponseDto;
import com.chldudgh.book.springboot.web.dto.PostsSaveRequestDto;
import com.chldudgh.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository; //생성자 주입

    @Transactional
    public Long save(PostsSaveRequestDto requestsDto) {
        //Dto에서 엔티티를 만들어서 저장함.
        return postsRepository.save(requestsDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        // 해당 아이디를 찾음.
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        //받은 객체를 가지고 업데이트를 수행함.
        //JPA의 영속성 컨텍스트!!!
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}
