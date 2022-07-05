package com.example.TargetLearning.controller;

import com.example.TargetLearning.dto.request.ProductRequest;
import com.example.TargetLearning.dto.response.ProductRespone;
import com.example.TargetLearning.entity.Product;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
    public void deleteEmployee(@PathVariable("id") Long id) {
        productService.deleteEmployee(id);
    }
    @DeleteMapping("/all")
    public void deleteAll(){
        productService.deleteAll();
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

    @PostMapping("/upload")
    public String uploadData(@RequestParam("file")MultipartFile file) throws Exception{
        List<Product> productsList =  new ArrayList<Product>();
        InputStream inputStream = file.getInputStream();
        CsvParserSettings setting = new CsvParserSettings();
        setting.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(setting);
        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
        parseAllRecords.forEach(record -> {
            Product product = new Product();
//            product.setId(Long.valueOf(record.getString("product_id")));
            product.setName(record.getString("name"));
            product.setCost_price(Float.valueOf(record.getString("cost_price")));
            product.setSelling_price(Float.valueOf(record.getString("selling_price")));
            product.setProduct_status(record.getString("productStatus"));
//            product.setCreatedDate(Date.from(Instant.parse(record.getString("createdDate"))));
//            product.setPublishedDate(Date.from(Instant.parse(record.getString("publishedDate"))));
//            product.setRetiredDate(Date.from(Instant.parse(record.getString("retiredDate"))));
            productsList.add(product);
        });
        productRepositiory.saveAll(productsList);
        return "Upload Sucessfull";

    }
}