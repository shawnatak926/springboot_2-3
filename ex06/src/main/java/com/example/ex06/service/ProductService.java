package com.example.ex06.service;

import com.example.ex06.entity.Product;
import com.example.ex06.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    public final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.get();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Product product) throws Exception {
        if (product.getId() == null) {
            throw new Exception("상품 id가 없어 수정할 수 없습니다.");
        }

        productRepository.findById(product.getId())
                .orElseThrow(() -> new Exception("해당하는 id " + product.getId() + "가 없어 수정할 수 없습니다."));

        return productRepository.save(product);
    }

    public boolean deleteProduct(Long id) throws Exception {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new Exception("해당하는 id " + id + "가 없어 삭제할 수 없습니다."));
        productRepository.delete(product);
        return true;
    }
}
