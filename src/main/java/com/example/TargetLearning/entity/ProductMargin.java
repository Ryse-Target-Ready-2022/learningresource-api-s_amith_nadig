package com.example.TargetLearning.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="mt_product_margin")
public class ProductMargin {
    @Id
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost_price")
    private Float cost_price;

    @Column(name = "selling_price")
    private Float selling_price;

    @Column(name = "margin")
    private Float marign;

}
