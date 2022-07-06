package com.example.TargetLearning.service.impl;

import com.example.TargetLearning.dto.mapper.ProductMapper;
import com.example.TargetLearning.dto.request.ProductMarginRequest;
import com.example.TargetLearning.dto.request.ProductRequest;
import com.example.TargetLearning.dto.response.ProductMarginResponse;
import com.example.TargetLearning.dto.response.ProductRespone;
import com.example.TargetLearning.entity.Product;

import com.example.TargetLearning.entity.ProductMargin;
import com.example.TargetLearning.repository.ProductMarginRepository;
import com.example.TargetLearning.repository.ProductRepositiory;
import com.example.TargetLearning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class ProductServiceImpl implements ProductService {

    private final ProductRepositiory productRepositiory;
    @Autowired
    ProductMarginRepository productMarginRepository;

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
    public void deleteProduct(Long id) {
        productRepositiory.deleteById(id);
    }

    @Override
    public void deleteAll(){
        productRepositiory.deleteAll();
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
            throw new RuntimeException("Product Id " + id + "Not Found !");
        }
        Product product = ProductMapper.MAPPER.fromRequestToEntity(productRequest);
        product.setId(id);
        productRepositiory.save(product);
        return ProductMapper.MAPPER.fromEntityToResponse(product);
    }

    @Override
    public ArrayList<ProductMargin> computeProfitMargin(ArrayList csvList){
        ArrayList<Product> csvReadList = csvList;
       ArrayList<ProductMargin> finalProductMargins = new ArrayList<>();

       csvReadList.forEach(csvRead->{
           ProductMargin productMargin = new ProductMargin();
           float margin = (csvRead.getSelling_price() - csvRead.getCost_price())/csvRead.getSelling_price();
           productMargin.setId(Long.valueOf(csvRead.getId()));
           productMargin.setName(csvRead.getName());
           productMargin.setCost_price(csvRead.getCost_price());
           productMargin.setSelling_price(csvRead.getSelling_price());
           productMargin.setMarign(margin);
           finalProductMargins.add(productMargin);
       });
       System.out.println(finalProductMargins);
       Collections.sort(finalProductMargins, Comparator.comparing(ProductMargin::getMarign)

               .reversed());
        System.out.println(finalProductMargins);
        productMarginRepository.saveAll(finalProductMargins);
        return null;
    }

    @Override
    public ProductMarginResponse saveProductMargins(ProductMarginRequest productMarginRequest) {
        return null;
    }


    @Override
    public List<ProductMargin>findAllMarginedProducts(){
        return productMarginRepository.findAll();

    }

    @Override
    public void deleteProductMargin(Long id) {
        productMarginRepository.deleteById(id);
    }




}
