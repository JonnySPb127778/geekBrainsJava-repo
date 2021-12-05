package com.geekbrains.spring.webjs.controllers;

import com.geekbrains.spring.webjs.data.Product;
import com.geekbrains.spring.webjs.exceptions.AppError;
import com.geekbrains.spring.webjs.exceptions.ResourceNotFoundException;
import com.geekbrains.spring.webjs.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getStudentById(@PathVariable Long id) {
        return productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found! ID: " + id));
    }
/*
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Optional <Product> product = productService.findById(id);
        if(product.isPresent()) {
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), "Product not found! ID: " + id), HttpStatus.NOT_FOUND);
    }
*/
    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
/*
    @GetMapping("/products/add")
    public void addById(@RequestParam Long   productId,
                        @RequestParam String productTitle,
                        @RequestParam String productUnit,
                        @RequestParam Float  productCost) {
        productService.addById(productId, productTitle, productUnit, productCost);
    }
*/
    @GetMapping("/products/change_cost")
    public void changeCost(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCost(productId, delta);
    }

    @GetMapping("/products/cost_between")
    public List<Product> findProductsByCostBetween(@RequestParam(defaultValue = "0") Float min, @RequestParam(defaultValue = "1000000") Float max) {
        return productService.findByCostBetween(min, max);
    }

    @GetMapping("/products/cost_min")
    public List<Product> findProductsByCostMin(@RequestParam(defaultValue = "0") Float min) {
        return productService.findByCostMin(min);
    }

    @GetMapping("/products/cost_max")
    public List<Product> findProductsByCostMax(@RequestParam(defaultValue = "1000") Float max) {
        return productService.findByCostMax(max);
    }
}
