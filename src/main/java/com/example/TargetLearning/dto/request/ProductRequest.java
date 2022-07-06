package com.example.TargetLearning.dto.request;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ProductRequest {
    private Long id;
    private String name;
    private Float cost_price;
    private Float selling_price;
    private String product_status;
    private LocalDateTime createdDate;
    private LocalDateTime publishedDate;
    private LocalDateTime retiredDate;
}
