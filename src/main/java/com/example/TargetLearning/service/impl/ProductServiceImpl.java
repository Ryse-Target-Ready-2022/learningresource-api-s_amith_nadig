package com.example.TargetLearning.service.impl;

import com.example.TargetLearning.dto.mapper.ProductMapper;
import com.example.TargetLearning.dto.request.ProductRequest;
import com.example.TargetLearning.dto.response.ProductRespone;
import com.example.TargetLearning.entity.Product;
import com.example.TargetLearning.repository.ProductRepositiory;
import com.example.TargetLearning.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class ProductServiceImpl implements ProductService {

    private final ProductRepositiory productRepositiory;

    public ProductServiceImpl(ProductRepositiory productRepositiory) {
        this.productRepositiory = productRepositiory;
    }

    @Override
    public List<Product>findAllProduct(){
        return productRepositiory.findAll();

    }

    @Override
    public Optional<Product> findById(Long id){
        return productRepositiory.findById(id);
    }

    @Override
    public Product saveProduct(Product product){
        return productRepositiory.save(product);
    }
    @Override
    public Product updateProduct(Product product){
        return productRepositiory.save(product);
    }

    @Override
    public void deleteEmployee(Long id) {
        productRepositiory.deleteById(id);
    }

    @Override
    public ProductRespone saveProduct(ProductRequest productRequest){
        Product product = ProductMapper.MAPPER.fromRequestToEntity(productRequest);
        productRepositiory.save(product);
        return ProductMapper.MAPPER.fromEntityToResponse(product);
    }
    @Override
    public ProductRespone updateProduct(ProductRequest productRequest,Long id){
        Optional<Product>checkExistingProduct = findById(id);
        if(!checkExistingProduct.isPresent()){
            throw new RuntimeException("Employee Id " + id + "Not Found !");
        }
        Product product = ProductMapper.MAPPER.fromRequestToEntity(productRequest);
        product.setId(id);
        productRepositiory.save(product);
        return ProductMapper.MAPPER.fromEntityToResponse(product);
    }
}
