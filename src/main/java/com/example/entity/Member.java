package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
@AllArgsConstructor
@Document(collection = "member")
public class Member {
    @Id
    private String id;
    private String name;
    private String profileUrl;
    private Integer age;
    private LocalDateTime createdAt;
}