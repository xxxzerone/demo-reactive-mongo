package com.example.controller;

import com.example.common.APIResponse;
import com.example.dto.MemberDTO;
import com.example.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/v1/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public Mono<APIResponse> create(
            @Validated
            @RequestBody MemberDTO.Create memberDTO) {
        log.info("memberDTO: {}", memberDTO);
        return memberService.create(memberDTO)
                .map(val -> APIResponse.builder()
                        .code(200)
                        .message("success")
                        .data(val)
                        .build());
    }

    @PatchMapping("/member/name/{id}")
    public Mono<APIResponse> updateName(
            @Validated
            @PathVariable("id") String id,
            @RequestBody MemberDTO.Item memberDTO) {
        return memberService.updateName(id, memberDTO.getName())
                .map(val -> APIResponse.builder()
                        .code(200)
                        .message("success")
                        .data(val)
                        .build())
                .switchIfEmpty(Mono.just(APIResponse
                        .builder()
                        .code(404)
                        .message("id not found")
                        .build()));
    }

    @GetMapping("/member/{id}")
    public Mono<APIResponse> select(@PathVariable("id") String id) {
        return memberService.select(id)
                .map(val -> APIResponse.builder()
                        .code(200)
                        .message("success")
                        .data(val)
                        .build());
    }

    @GetMapping("/member/list/{page}")
    public Mono<APIResponse> list(
            @PathVariable("page") Integer page,
            @RequestParam(value = "limit", defaultValue = "10")
            Integer limit) {
        return memberService.list(page, limit)
                .collectList()
                .map(val -> APIResponse.builder()
                        .code(200)
                        .page(page)
                        .limit(limit)
                        .message("success")
                        .data(val)
                        .build());
    }

}