package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddItemInPut {
    private Long id;
    private String name;
    private String description;
    private int startingPrice;
}
