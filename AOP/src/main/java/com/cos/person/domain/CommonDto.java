package com.cos.person.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CommonDto<T>{
    private int statusCode;
    private T data;

    public CommonDto(int statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public CommonDto(int statusCode) {
        this.statusCode = statusCode;
    }
}
