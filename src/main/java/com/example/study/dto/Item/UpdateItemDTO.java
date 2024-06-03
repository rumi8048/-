package com.example.study.dto.Item;

import com.example.study.entity.Item;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class UpdateItemDTO {
    @NotNull(message = "가격을 입력해야 합니다.")
    @Min(value = 100, message = "가격은 최소 100원이어야 합니다.")
    @Max(value = 10000000, message = "가격은 최대 10,000,000원이어야 합니다.")
    private Integer price;

    @NotBlank(message = "설명은 비워둘 수 없습니다.")
    private String description;
}