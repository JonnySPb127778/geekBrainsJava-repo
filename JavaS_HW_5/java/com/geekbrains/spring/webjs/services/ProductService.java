package com.geekbrains.spring.webjs.services;

import com.geekbrains.spring.webjs.data.Product;
import com.geekbrains.spring.webjs.repositories.ProductDaoImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDaoImpl productDaoImpl;

    public ProductService(ProductDaoImpl productDaoImpl) {
        this.productDaoImpl = productDaoImpl;
    }

    public List<Product> getAllProducts() { return productDaoImpl.findAll(); }

    public void deleteById(Long id) {
        productDaoImpl.deleteById(id);
    }
/*
    public void addById(Long   id,
                        String title,
                        String unit,
                        Float  cost) {
        productDaoImpl.addById(id, title, unit, cost);
    }
*/
    public void changeCost(Long productId, Integer delta) {
        Product product = productDaoImpl.findById(productId);
        Float newCost = product.getCost() + delta;
        if(newCost < 0) newCost = 0f;
        product.setCost(newCost);
        productDaoImpl.saveOrUpdate(product);
    }
}
