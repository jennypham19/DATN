package com.example.reactproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "store_id", nullable = false)
    private Long store_id;

    @Column(name = "date_imported")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "mm/dd/yy")
    private Date date_imported;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "price_import")
    private float price_imported;

    @Column(name = "number")
    private Long number;

    public Store() {
    }

    public Store(Long store_id, Date date_imported, String product_name, float price_imported, Long number, List<Provider> providers) {
        this.store_id = store_id;
        this.date_imported = date_imported;
        this.product_name = product_name;
        this.price_imported = price_imported;
        this.number = number;
        this.providers = providers;
    }

    // Quan hệ nhiều - nhiều của bảng người cung cấp và nhập kho
    @ManyToMany()
    @JoinTable(
            name="provider_store",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "provider_id")
    )


    private List<Provider> providers;

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }

    public Date getDate_imported() {
        return date_imported;
    }

    public void setDate_imported(Date date_imported) {
        this.date_imported = date_imported;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public float getPrice_imported() {
        return price_imported;
    }

    public void setPrice_imported(float price_imported) {
        this.price_imported = price_imported;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public void setProviders(List<Provider> providers) {
        this.providers = providers;
    }
}
