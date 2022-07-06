package com.example.TargetLearning.dto.response;

import lombok.Data;

@Data

public class ProductMarginResponse {
    private Long id;
    private String name;
    private Float cost_price;
    private Float selling_price;
    private Float marign;
}
