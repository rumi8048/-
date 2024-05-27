package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorResponse {
    private int errorCode;
    private List<String> errorMessages;
}
