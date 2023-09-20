package com.example.chatgpt.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatGPTQueryRequest {

    @NotBlank
    private String model;

    @NotBlank
    private String prompt;

    @NotNull
    private int temperature;

    @NotNull
    private int max_tokens;
}