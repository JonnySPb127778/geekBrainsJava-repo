package com.geekbrains.spring.webjs.repositories;

import com.geekbrains.spring.webjs.data.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Хлеб", "бух.", 68.95F),
                new Product(2L, "Молоко", "л", 75.35F),
                new Product(3L, "Яицо","дес.шт.",  59.99F),
                new Product(4L, "Сыр", "кг", 585.69F),
                new Product(5L, "Говядина","кг",  480.99F)

        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public void deleteById(Long id) {
        products.removeIf(s -> s.getId().equals(id));
    }

    public void addById(Long   id,
                        String title,
                        String unit,
                        Float  cost) {
        products.add(new Product(id, title, unit, cost));
    }

    public Product findById(Long id) {
        return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }
}
