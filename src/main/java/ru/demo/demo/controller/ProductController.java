package ru.demo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.demo.demo.model.Product;
import ru.demo.demo.service.ProductService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = ProductController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    public static final String REST_URL = "/api/v1/products";

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public Product get(@PathVariable("id") Long id) {
        log.info("get " + id);
        return productService.get(id);
    }

    @GetMapping
    public List<Product> getAll() {
        log.info("getAll");
        return productService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product save(@RequestBody Product product) {
        log.info("save " + product);
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        log.info("delete " + id);
        productService.delete(id);
    }
}
