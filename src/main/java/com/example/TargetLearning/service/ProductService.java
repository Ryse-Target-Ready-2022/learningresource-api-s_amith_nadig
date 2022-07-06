package com.example.TargetLearning.service;


import com.example.TargetLearning.dto.request.ProductMarginRequest;
import com.example.TargetLearning.dto.request.ProductRequest;
import com.example.TargetLearning.dto.response.ProductMarginResponse;
import com.example.TargetLearning.dto.response.ProductRespone;
import com.example.TargetLearning.entity.Product;
import com.example.TargetLearning.entity.ProductMargin;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface ProductService {
    List<Product> findAllProduct();

    Optional<Product> findById(Long id);

    Product saveProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long id);


    void deleteAll();

    ProductRespone saveProduct(ProductRequest productRequest);

    ProductRespone updateProduct(ProductRequest productRequest, Long id);


    ArrayList<ProductMargin> computeProfitMargin(ArrayList csvList);

    ProductMarginResponse saveProductMargins(ProductMarginRequest productMarginRequest);

    List<ProductMargin>findAllMarginedProducts();

    void deleteProductMargin(Long id);
}
