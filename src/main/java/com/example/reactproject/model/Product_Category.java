package com.example.reactproject.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_category")
public class Product_Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_category_id",nullable = false)
    private Long product_category_id;

    @Column(name = "product_category_name")
    private  String product_category_name;

    //Quan hệ một - nhiều của bảng loại sản phẩm với sản phẩm
    @OneToMany(mappedBy = "id_product")
    private List<Product> listProduct;

    public Product_Category() {
    }

    public Product_Category(Long product_category_id, String product_category_name) {
        this.product_category_id = product_category_id;
        this.product_category_name = product_category_name;
    }


    public Long getProduct_category_id() {
        return product_category_id;
    }

    public void setProduct_category_id(Long product_category_id) {
        this.product_category_id = product_category_id;
    }

    public String getProduct_category_name() {
        return product_category_name;
    }

    public void setProduct_category_name(String product_category_name) {
        this.product_category_name = product_category_name;
    }
}
