package com.example.demo;

import lombok.Builder;

@Builder
public class Result<T> {
    String message;
    T data;
}
