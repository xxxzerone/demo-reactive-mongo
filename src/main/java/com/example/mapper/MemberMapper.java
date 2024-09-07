package com.example.mapper;

import com.example.dto.MemberDTO;
import com.example.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberMapper {

    public MemberDTO.Item ToDTOItem(Member entity) {
        return MemberDTO.Item.builder()
                .id(entity.getId())
                .name(entity.getName())
                .age(entity.getAge())
                .profileUrl(entity.getProfileUrl())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public Member ToCreateEntity(MemberDTO.Create dto) {
        return Member.builder()
                .name(dto.getName())
                .profileUrl(dto.getProfileUrl())
                .age(dto.getAge())
                .createdAt(dto.getCreatedAt())
                .build();
    }

    public Member ToItemEntity(MemberDTO.Item dto) {
        return Member.builder()
                .name(dto.getName())
                .age(dto.getAge())
                .profileUrl(dto.getProfileUrl())
                .createdAt(dto.getCreatedAt())
                .build();
    }

}