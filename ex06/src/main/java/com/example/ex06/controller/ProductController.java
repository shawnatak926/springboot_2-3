package com.example.ex06.controller;


import com.example.ex06.entity.Product;
import com.example.ex06.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        System.out.println("id = "+id);
        Product product = productService.findById(id);
        return product;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) throws Exception {
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "상품을 삭제합니다")
    public boolean delete(@PathVariable Long id) throws Exception {
        return productService.deleteProduct(id);
    }
}
