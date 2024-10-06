package com.example.demo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Result<T> {
    String message;
    T data;
}
