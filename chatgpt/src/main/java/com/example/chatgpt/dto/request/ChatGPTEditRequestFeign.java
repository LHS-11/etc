package com.example.chatgpt.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatGPTEditRequestFeign {

    private String model;
    private String input;
    private String instruction;

    private ChatGPTEditRequestFeign(String model, String input, String instruction) {
        this.model = model;
        this.input = input;
        this.instruction = instruction;
    }

    public static ChatGPTEditRequestFeign from(ChatGPTEditRequest chatGPTEditRequest){
        return new ChatGPTEditRequestFeign(chatGPTEditRequest.getModel(), chatGPTEditRequest.getInput(), chatGPTEditRequest.getInstruction());
    }
}
