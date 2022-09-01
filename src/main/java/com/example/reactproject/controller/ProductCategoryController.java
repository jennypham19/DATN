package com.example.reactproject.controller;

import com.example.reactproject.exception.ResourceNotFoundException;
import com.example.reactproject.model.Product_Category;
import com.example.reactproject.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    //get all
    @GetMapping("/product_category")
    public List<Product_Category> getAllProductCategory() {
        return productCategoryRepository.findAll();
    }

    //create
    @PostMapping("/product_category/create")
    public Product_Category createProductCategory(@RequestBody Product_Category product_category) {
        return productCategoryRepository.save(product_category);
    }

    //get id
    @GetMapping("/product_category/{id}")
    public ResponseEntity<Product_Category> getProductCategoryId(@PathVariable Long id){
        Product_Category product_category = productCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product category not exist with id: "+id));
        return ResponseEntity.ok(product_category);
    }

    //update
    @PutMapping("/product_category/{id}")
    public  ResponseEntity<Product_Category> updateProductCategory(@PathVariable Long id,@RequestBody Product_Category product_category_details ){
        Product_Category product_category = productCategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product category not exist with id: "+id));
        product_category.setProduct_category_name(product_category_details.getProduct_category_name());
        Product_Category updateProductCategory = productCategoryRepository.save(product_category);
        return ResponseEntity.ok(updateProductCategory);
    }
}
