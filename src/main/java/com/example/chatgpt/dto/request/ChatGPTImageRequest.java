package com.example.chatgpt.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatGPTImageRequest {

    @NotBlank
    private String prompt;

    @NotNull
    private int n;

    @NotBlank
    private String size;
}
