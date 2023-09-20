package com.example.chatgpt.dto.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class ChatGPTImageResponse {

    @JsonProperty("data")
    private List<Data> data;

    public static class Data{

        @JsonProperty("url")
        private String url;
    }


}
