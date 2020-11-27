package ru.demo.demo.service;

import ru.demo.demo.model.Product;

import java.util.List;

public interface ProductService {
    Product get(Long id);

    List<Product> getAll();

    Product save(Product product);

    Product update(Product product);

    void delete(Long id);
}
