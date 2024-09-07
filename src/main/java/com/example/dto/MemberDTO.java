package com.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.List;

public class MemberDTO {

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Items {
        @JsonProperty("code")
        private Integer code;

        @JsonProperty("message")
        private String message;

        @JsonProperty("data")
        private List<Item> data;
    }

    @Builder
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Create {
        @NotEmpty
        @Length(min = 5, max = 128)
        @JsonProperty("name")
        private String name;

        @NotEmpty
        @Length(min = 13, max = 1024)
        @JsonProperty("profile_url")
        private String profileUrl;

        @Min(10)
        @Max(90)
        @JsonProperty("age")
        private Integer age;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonProperty("created_at")
        private LocalDateTime createdAt;
    }

    @Builder
    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {
        @JsonProperty("id")
        private String id;
        @JsonProperty("name")
        private String name;
        @JsonProperty("profile_url")
        private String profileUrl;
        @JsonProperty("age")
        private Integer age;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        @JsonProperty("created_at")
        private LocalDateTime createdAt;
    }

}