package com.example.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class APIResponse {
    @JsonProperty("code")
    private Integer code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("page")
    private Integer page;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("limit")
    private Integer limit;

    @JsonProperty("message")
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("data")
    private Object data;
}