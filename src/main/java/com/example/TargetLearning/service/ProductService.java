package com.example.TargetLearning.service;


import com.example.TargetLearning.dto.request.ProductRequest;
import com.example.TargetLearning.dto.response.ProductRespone;
import com.example.TargetLearning.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ProductService {
    List<Product> findAllProduct();

    Optional<Product> findById(Long id);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    void deleteEmployee(Long id);


    ProductRespone saveProduct(ProductRequest productRequest);

    ProductRespone updateProduct(ProductRequest productRequest, Long id);
}
