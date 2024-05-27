package com.example.study.controller.calculator;


import com.example.study.dto.calculator.CalculatorAddRequest;
import com.example.study.dto.calculator.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @PostMapping("/add")
    public int addTwoNumbers( @RequestBody CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }
    @GetMapping("/calc")
    public String calc(@RequestParam int number1, @RequestParam int number2) {
        int add= number1+number2;
        int minus = number1 - number2;
        int multiply = number1 * number2;
        double division = number1 / (double) number2;

        return "add = "+ add+ "\nminus = "+minus+ "\nmultiply = "+multiply + "\ndivision = "+division ;
    }

}
