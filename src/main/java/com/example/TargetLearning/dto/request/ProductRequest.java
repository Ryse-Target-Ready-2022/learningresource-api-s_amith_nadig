package com.example.TargetLearning.dto.request;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProductRequest {
    private Long id;
    private String name;
    private Float cost_price;
    private Float selling_price;
    private String product_status;
    private Date createdDate;
    private Date publishedDate;
    private Date retiredDate;
}
