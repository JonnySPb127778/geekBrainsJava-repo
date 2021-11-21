package com.geekbrains.spring.webjs.services;

import com.geekbrains.spring.webjs.data.Product;
import com.geekbrains.spring.webjs.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void addById(Long   id,
                        String title,
                        String unit,
                        Float  cost) {
        productRepository.addById(id, title, unit, cost);
    }

    public void changeScore(Long productId, Integer delta) {
        Product product = productRepository.findById(productId);
        product.setCost(product.getCost() + delta);
        // productRepository.save(product);
    }
}
