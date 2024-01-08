package com.pratik1704.productservice.controller;

import com.pratik1704.productservice.dto.ProductRequest;
import com.pratik1704.productservice.dto.ProductResponse;
import com.pratik1704.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
        log.info("Product has been created");
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        log.info("Getting all the products");
        return productService.getAllProducts();
    }

}
