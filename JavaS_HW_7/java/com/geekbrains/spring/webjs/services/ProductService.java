package com.geekbrains.spring.webjs.services;

import com.geekbrains.spring.webjs.data.Product;
import com.geekbrains.spring.webjs.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.webjs.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
/*
    public void addById(Long   id,
                        String title,
                        String unit,
                        Float  cost) {
        productRepository.addById(id, title, unit, cost);
    }
*/

    @Transactional
    public void changeCost(Long productId, Integer delta) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Unable to change product's cost. Product not found, ID: " + productId));
        product.setCost(product.getCost() + delta);
    }

    public List<Product> findByCostBetween(Float min, Float max) {
        return productRepository.findAllByCostBetween(min, max);
    }

    public List<Product> findByCostMin(Float min) {
        return productRepository.findAllByCostMin(min);
    }

    public List<Product> findByCostMax(Float max) {
        return productRepository.findAllByCostMax(max);
    }

}
