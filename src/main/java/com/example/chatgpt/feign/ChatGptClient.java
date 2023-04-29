package com.example.chatgpt.feign;

import com.example.chatgpt.dto.reponse.ChatGPTResponse;
import com.example.chatgpt.dto.request.ChatGPTRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name ="chatGptClient",
        url ="https://api.openai.com/v1",
        configuration =FeignConfig.class
)
public interface ChatGptClient {


//    @Headers({
//            "Content-Type: application/json",
//            "Authorization: Bearer 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"
//    })
    @PostMapping("/completions")
    ChatGPTResponse getGptApiResponse(@RequestBody ChatGPTRequest chatGPTRequest);
}
