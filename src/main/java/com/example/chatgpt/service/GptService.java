package com.example.chatgpt.service;


import com.example.chatgpt.dto.reponse.ChatGPTResponse;
import com.example.chatgpt.dto.request.ChatGPTRequest;
import com.example.chatgpt.dto.request.ChatGPTQueryRequest;
import com.example.chatgpt.feign.ChatGptClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GptService {

    private final ChatGptClient client;

    public ChatGPTResponse getAnswer(ChatGPTQueryRequest chatGPTQueryRequest){
        log.info(chatGPTQueryRequest.toString());
        ChatGPTResponse chatGPTResponse = client.getGptApiResponse(ChatGPTRequest.from(chatGPTQueryRequest));

        return chatGPTResponse;
    }
}
