package com.geekbrains.spring.webjs.repositories;

import com.geekbrains.spring.webjs.data.Product;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    Product findById(Long id);
    Product findByTitle(String title);
    List<Product> findAll();
    void saveOrUpdate(Product product);
    void deleteById(Long id);
    void updateTitleById(Long id, String newTitle);
    void testCaching();
}
