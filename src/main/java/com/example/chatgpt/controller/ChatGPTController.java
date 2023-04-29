package com.example.chatgpt.controller;

import com.example.chatgpt.base.BaseResponse;
import com.example.chatgpt.dto.reponse.ChatGPTImageResponse;
import com.example.chatgpt.dto.reponse.ChatGPTResponse;
import com.example.chatgpt.dto.request.ChatGPTEditRequest;
import com.example.chatgpt.dto.request.ChatGPTImageRequest;
import com.example.chatgpt.dto.request.ChatGPTQueryRequest;
import com.example.chatgpt.service.GptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/gpt")
@RestController
public class ChatGPTController {

    private final GptService gptService;

    /**
     * 질의 응답을 주고받는 API
     * @param chatGPTQueryRequest
     * @param bindingResult
     * @return
     */
    @PostMapping("/query")
    public BaseResponse<ChatGPTResponse> callApi(@Validated @RequestBody
                                                 ChatGPTQueryRequest chatGPTQueryRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
            return BaseResponse.onFailure(400, objectError.getDefaultMessage(),null);
        }
        log.info(chatGPTQueryRequest.toString());
        ChatGPTResponse answer = gptService.getQueryAnswer(chatGPTQueryRequest);
        log.info(answer.toString());
        return BaseResponse.onSuccess(answer);
    }

    @PostMapping("/edit")
    public BaseResponse<ChatGPTResponse> callEditApi(@Validated @RequestBody
                                                     ChatGPTEditRequest chatGPTEditRequest, BindingResult bindingResult){
        log.info(chatGPTEditRequest.toString());
        if(bindingResult.hasErrors()){
            ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
            return BaseResponse.onFailure(400, objectError.getDefaultMessage(),null);
        }
        ChatGPTResponse answer = gptService.getEditAnswer(chatGPTEditRequest);
        return BaseResponse.onSuccess(answer);
    }

    @PostMapping("/generate/image")
    public BaseResponse<ChatGPTImageResponse> callImageApi(@Validated @RequestBody
                                                           ChatGPTImageRequest chatGPTImageRequest, BindingResult bindingResult){
        log.info(chatGPTImageRequest.toString());
        if(bindingResult.hasErrors()){
            ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
            return BaseResponse.onFailure(400, objectError.getDefaultMessage(),null);
        }
        ChatGPTImageResponse image = gptService.getImage(chatGPTImageRequest);
        return BaseResponse.onSuccess(image);
    }




    

}
