package com.example.TargetLearning.controller;

import com.example.TargetLearning.dto.request.ProductRequest;
import com.example.TargetLearning.dto.response.ProductRespone;
import com.example.TargetLearning.entity.Product;
import com.example.TargetLearning.entity.ProductMargin;
import com.example.TargetLearning.repository.ProductRepositiory;
import com.example.TargetLearning.service.ProductService;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    ProductRepositiory productRepositiory;
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
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
    @DeleteMapping("/all")
    public void deleteAll(){
        productService.deleteAll();
    }


    @PostMapping("/res")
    public ProductRespone saveProResponse(@RequestBody ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }

    @PutMapping("/res/{id}")
    public ProductRespone updateProResponse(@RequestBody ProductRequest productRequest, @PathVariable("id") Long id) {
        return productService.updateProduct(productRequest, id);
    }

    @PostMapping("/products/profits/upload")
    public String uploadData(@RequestParam("file")MultipartFile file) throws Exception{
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
            ArrayList<Product> productsList =  new ArrayList<Product>();
            InputStream inputStream = file.getInputStream();
            CsvParserSettings setting = new CsvParserSettings();
            setting.setHeaderExtractionEnabled(true);
            CsvParser parser = new CsvParser(setting);
            ArrayList<Record> parseAllRecords = (ArrayList<Record>) parser.parseAllRecords(inputStream);
            parseAllRecords.forEach(record -> {
                Product product = new Product();
                product.setId(Long.valueOf(record.getString("product_id")));
                product.setName(record.getString("name"));
                product.setCost_price(Float.valueOf(record.getString("cost_price")));
                product.setSelling_price(Float.valueOf(record.getString("selling_price")));
                product.setProduct_status(record.getString("productStatus"));
                LocalDateTime createdDate = LocalDateTime.parse(record.getString("createdDate"), dateFormatter);
                product.setCreatedDate( createdDate);
                LocalDateTime publishedDate = LocalDateTime.parse(record.getString("publishedDate"),dateFormatter);
                product.setPublishedDate(publishedDate);
                LocalDateTime retiredDate = LocalDateTime.parse(record.getString("retiredDate"),dateFormatter);
                product.setRetiredDate(retiredDate);
                productsList.add(product);
            });
            productService.computeProfitMargin(productsList);
//        productRepositiory.saveAll(productsList);
            return "Upload Successful";
        }catch (Exception e){
            throw new Exception("Failed");
        }


    }
    @GetMapping("/profitslist")
    public List<ProductMargin>findAllMarginedProducts(){
        return productService.findAllMarginedProducts();
    }

    @DeleteMapping("/profitmargin/{id}")
    public void deleteProductmargin(@PathVariable("id") Long id) {
        productService.deleteProductMargin(id);
    }



}