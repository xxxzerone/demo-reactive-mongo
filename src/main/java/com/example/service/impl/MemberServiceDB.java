package com.example.service.impl;

import com.example.dto.MemberDTO;
import com.example.mapper.MemberMapper;
import com.example.repository.MemberRepository;
import com.example.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberServiceDB implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public Mono<MemberDTO.Item> create(MemberDTO.Create dto) {
        dto.setCreatedAt(LocalDateTime.now());
        return memberRepository.save(memberMapper.ToCreateEntity(dto))
                .map(memberMapper::ToDTOItem);
    }

    @Override
    public Mono<MemberDTO.Item> select(String id) {
        return memberRepository.findById(id)
                .map(memberMapper::ToDTOItem);
    }

    @Override
    public Mono<MemberDTO.Item> updateName(String id, String name) {
        return memberRepository.updateName(id, name)
                .flatMap(len -> memberRepository.findById(id)
                        .map(memberMapper::ToDTOItem));
    }

    @Override
    public Flux<MemberDTO.Item> list(Integer page, Integer size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page - 1);
        return memberRepository.findAllByPage(pageable);
    }
}