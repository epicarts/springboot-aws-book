package com.chldudgh.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //생성된 모든 final 필드의 생성자를 생성함
public enum Role {

    GUEST("ROLE_GUEST", "손님"),//스프링에는 ROLE이 붙어야함
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
