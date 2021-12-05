package com.geekbrains.spring.webjs.repositories;

import com.geekbrains.spring.webjs.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // @Query("select p from Product p where p.cost between ?1 and ?2")
    List<Product> findAllByCostBetween(Float min, Float max);

    @Query("select p from Product p where p.cost > ?1")
    List<Product> findAllByCostMin(Float min);

    @Query("select p from Product p where p.cost < ?1")
    List<Product> findAllByCostMax(Float max);

    // @Query("select s from Product p where p.title = :title")
    Optional<Product> findByTitle(String name);

    @Query("select p from Product p where p.cost < 40")
    List<Product> findLowCostProducts();

    @Query("select p.cost from Product p where p.title = ?1")
    Float hqlGetCostByTitle(String title);

    @Query(value = "select cost from products where title = :title", nativeQuery = true)
    Integer nativeSqlGetCostByTitle(String title);

    // Если бы у студентов был List<Book>, то не ленивая загрузка книг:
    // @Query("select s from Student s join fetch s.books where s.id = :id")
    // Optional<Student> findByIdWithBooks(String name);

}
