package com.example.TargetLearning.repository;

import com.example.TargetLearning.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositiory extends JpaRepository<Product,Long> {

}
