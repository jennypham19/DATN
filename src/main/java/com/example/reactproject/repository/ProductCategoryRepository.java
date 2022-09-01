package com.example.reactproject.repository;

import com.example.reactproject.model.Product_Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<Product_Category,Long> {
}
