package com.example.reactproject.controller;

import com.example.reactproject.model.Product;
import com.example.reactproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    //get all
    @GetMapping("/product")
    public List<Product> getAllProductCategory() {
        return productRepository.findAll();
    }
}
