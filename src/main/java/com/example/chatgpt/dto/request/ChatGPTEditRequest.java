package com.example.chatgpt.dto.request;

import lombok.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChatGPTEditRequest {

    @NotBlank
    private String model;
    @NotBlank
    private String input;
    @NotBlank
    private String instruction;
}
