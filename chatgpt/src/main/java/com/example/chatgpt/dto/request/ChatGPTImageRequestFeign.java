package com.example.chatgpt.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatGPTImageRequestFeign {

    private String prompt;
    private int n;
    private String size;

    private ChatGPTImageRequestFeign(String prompt, int n, String size) {
        this.prompt = prompt;
        this.n = n;
        this.size = size;
    }

    public static ChatGPTImageRequestFeign from(ChatGPTImageRequest chatGPTImageRequest){
        return new ChatGPTImageRequestFeign(chatGPTImageRequest.getPrompt(), chatGPTImageRequest.getN(), chatGPTImageRequest.getSize());
    }
}
