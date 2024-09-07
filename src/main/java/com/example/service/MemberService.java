package com.example.service;

import com.example.dto.MemberDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MemberService {
    Mono<MemberDTO.Item> create(MemberDTO.Create dto);

    Mono<MemberDTO.Item> select(String id);

    Mono<MemberDTO.Item> updateName(String id, String name);

    Flux<MemberDTO.Item> list(Integer page, Integer size);
}