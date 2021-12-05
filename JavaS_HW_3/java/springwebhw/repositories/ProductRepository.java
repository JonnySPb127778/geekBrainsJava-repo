package springwebhw.repositories;

import springwebhw.data.Product;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Primary
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    private void initProducts() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 68.9f),
                new Product(2L, "Milk", 75.35f),
                new Product(3L, "Eggs", 59.99f),
                new Product(4L, "Cheese", 585.60f),
                new Product(5L, "Meat", 480.99f)
        ));

    }

    public Product findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id)).findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

}
