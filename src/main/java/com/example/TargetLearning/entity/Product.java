package com.example.TargetLearning.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="mt_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost_price")
    private Float cost_price;

    @Column(name = "selling_price")
    private Float selling_price;

    @Column(name = "productStatus")
    private String product_status;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "publishedDate")
    private Date  publishedDate;

    @Column(name = "retiredDate")
    private Date retiredDate;

}
