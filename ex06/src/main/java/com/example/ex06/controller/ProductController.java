package com.example.ex06.controller;


import com.example.ex06.entity.Member;
import com.example.ex06.entity.Product;
import com.example.ex06.service.MemberService;
import com.example.ex06.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    public final ProductService ProductService;
    public ProductController(ProductService productService) {
        ProductService = productService;
    }

    @GetMapping
    public List<Product> findAll() {
        return ProductService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        System.out.println("id = "+id);
        Product product = ProductService.findById(id);
        return product;
    }

}
