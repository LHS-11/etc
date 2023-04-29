package com.example.chatgpt.feign;

import com.example.chatgpt.dto.reponse.ChatGPTImageResponse;
import com.example.chatgpt.dto.reponse.ChatGPTResponse;
import com.example.chatgpt.dto.request.ChatGPTEditRequestFeign;
import com.example.chatgpt.dto.request.ChatGPTImageRequestFeign;
import com.example.chatgpt.dto.request.ChatGPTQueryRequestFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name ="chatGptClient",
        url ="https://api.openai.com/v1",
        configuration =FeignConfig.class
)
public interface ChatGptClient {

    @PostMapping("/completions")
    ChatGPTResponse getGPTQueryApiResponse(@RequestBody ChatGPTQueryRequestFeign chatGPTQueryRequestFeign);

    @PostMapping("/edits")
    ChatGPTResponse getGPTEditApiResponse(@RequestBody ChatGPTEditRequestFeign chatGPTEditRequestFeign);

    @PostMapping("/images/generations")
    ChatGPTImageResponse getGPTImageApiResponse(@RequestBody ChatGPTImageRequestFeign chatGPTImageRequestFeign);

}
