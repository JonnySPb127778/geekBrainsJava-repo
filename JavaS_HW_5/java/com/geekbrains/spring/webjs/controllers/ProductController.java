package com.geekbrains.spring.webjs.controllers;

import com.geekbrains.spring.webjs.data.Product;
import com.geekbrains.spring.webjs.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

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
}
