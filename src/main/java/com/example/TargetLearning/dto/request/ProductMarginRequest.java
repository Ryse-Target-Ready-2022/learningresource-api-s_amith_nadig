package com.example.TargetLearning.dto.request;

import lombok.Data;

@Data
public class ProductMarginRequest {
    private Long id;
    private String name;
    private Float cost_price;
    private Float selling_price;
    private Float marign;
}
