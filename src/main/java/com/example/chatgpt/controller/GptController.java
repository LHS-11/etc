package com.example.chatgpt.controller;

import com.example.chatgpt.base.BaseResponse;
import com.example.chatgpt.dto.reponse.ChatGPTResponse;
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
public class GptController {

    private final GptService gptService;

    /**
     * 질의 응답을 주고받는 API
     * @param chatGPTQueryRequest
     * @param bindingResult
     * @return
     */
    @PostMapping
    public BaseResponse<ChatGPTResponse> callApi(@Validated @RequestBody
                                                 ChatGPTQueryRequest chatGPTQueryRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
            return BaseResponse.onFailure(400, objectError.getDefaultMessage(),null);
        }
        log.info(chatGPTQueryRequest.toString());
        ChatGPTResponse answer = gptService.getAnswer(chatGPTQueryRequest);
        log.info(answer.toString());
        return BaseResponse.onSuccess(answer);
    }

    

}
