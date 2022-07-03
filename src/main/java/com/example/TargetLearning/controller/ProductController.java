package com.example.TargetLearning.controller;

import com.example.TargetLearning.dto.request.ProductRequest;
import com.example.TargetLearning.dto.response.ProductRespone;
import com.example.TargetLearning.entity.Product;
import com.example.TargetLearning.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product>findAllProduct(){
        return productService.findAllProduct();
    }
    @GetMapping("/{id}")
    public Optional<Product> findEmployeeById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        productService.deleteEmployee(id);
    }

//    Using Request and Response with save and update employee

    @PostMapping("/res")
    public ProductRespone saveProResponse(@RequestBody ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }

    @PutMapping("/res/{id}")
    public ProductRespone updateProResponse(@RequestBody ProductRequest productRequest, @PathVariable("id") Long id) {
        return productService.updateProduct(productRequest, id);
    }
}
