package com.example.study.controller.dto.calculator;

import com.example.study.controller.calculator.CalculatorController;
import lombok.Getter;

@Getter
public class CalculatorAddRequest {
    private final int number1;
    private final int number2;

    public CalculatorAddRequest(int number1, int number2){
        this.number1 = number1;
        this.number2= number2;

    }
}
