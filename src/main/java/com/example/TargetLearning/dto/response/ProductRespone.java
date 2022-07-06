package com.example.TargetLearning.dto.response;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ProductRespone implements Serializable {
    private Long id;
    private String name;
    private Float cost_price;
    private Float selling_price;
    private String product_status;
    private LocalDateTime createdDate;
    private LocalDateTime  publishedDate;
    private LocalDateTime retiredDate;
}
