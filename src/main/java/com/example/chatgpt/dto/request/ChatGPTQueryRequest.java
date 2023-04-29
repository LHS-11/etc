package com.example.chatgpt.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

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

    @NotBlank
    private int temperature;

    @NotBlank
    private int max_tokens;
}