package com.example.chatgpt.service;


import com.example.chatgpt.dto.reponse.ChatGPTImageResponse;
import com.example.chatgpt.dto.reponse.ChatGPTResponse;
import com.example.chatgpt.dto.request.*;
import com.example.chatgpt.feign.ChatGptClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GptService {

    private final ChatGptClient client;

    public ChatGPTResponse getQueryAnswer(ChatGPTQueryRequest chatGPTQueryRequest){
        log.info(chatGPTQueryRequest.toString());
        ChatGPTResponse chatGPTResponse = client.getGptApiResponse(ChatGPTQueryRequestFeign.from(chatGPTQueryRequest));
        return chatGPTResponse;
    }

    public ChatGPTResponse getEditAnswer(ChatGPTEditRequest chatGPTEditRequest){
        log.info(chatGPTEditRequest.toString());
        ChatGPTResponse chatGPTResponse = client.getGPTEditApiResponse(ChatGPTEditRequestFeign.from(chatGPTEditRequest));
        return chatGPTResponse;
    }

    public ChatGPTImageResponse getImage(ChatGPTImageRequest chatGPTImageRequest){
        log.info(chatGPTImageRequest.toString());
        ChatGPTImageResponse chatGPTImageResponse = client.getGPTImageApiResponse(ChatGPTImageRequestFeign.from(chatGPTImageRequest));
        return chatGPTImageResponse;
    }

}
