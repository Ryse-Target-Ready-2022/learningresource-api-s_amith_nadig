package com.tgt.rysetti.learningresourcesapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "learningresources")
public class LearningResource implements Serializable {
    @Id
    @Column(name = "learning_resource_id")
    private Integer learningResourceId;
    @Column(name = "learning_resource_name")
    private String learningResourceName;
    @Column(name = "cost_price")
    private Double costPrice;
    @Column(name = "selling_price")
    private Double sellingPrice;
    @Column(name = "learning_resource_status")
    @Enumerated(EnumType.STRING)
    private LearningResourceStatus learningResourceStatus;
    @Column(name = "created_date")
    private LocalDate createdDate;
    @Column(name = "published_date")
    private LocalDate publishedDate;
    @Column(name = "retired_date")
    private LocalDate retiredDate;

}
