package com.example.TargetLearning.repository;

import com.example.TargetLearning.entity.ProductMargin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMarginRepository extends JpaRepository<ProductMargin,Long> {

}
