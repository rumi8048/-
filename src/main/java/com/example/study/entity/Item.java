package com.example.study.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "상품 이름은 비워둘 수 없습니다.")
    private Long id;

    private String name;
    @NotBlank(message = "상품 설명은 비워둘 수 없습니다.")
    private String description;
    @NotNull(message = "시작 가격을 입력해야 합니다.")
    @Min(value = 100, message = "시작 가격은 최소 100원이어야 합니다.")
    @Max(value = 10000000, message = "시작 가격은 최대 10,000,000원이어야 합니다.")
    private int startingPrice;

    public void setId(Long id) {
        this.id = id;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public void setStartingPrice(int startingPrice) {
        this.startingPrice = startingPrice;
    }
}
