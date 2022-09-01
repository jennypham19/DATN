package com.example.reactproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;

    @Column(name = "product_code")
    private String product_code;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "sell_price")
    private Float sell_price;

    @Column(name = "unit")
    private String unit;

    @Column(name = "description")
    private String description;

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "mm/dd/yy")
    private Date date_created;

    @Column(name = "status")
    private String status;

    @Column(name = "product_img")
    private String product_img;

    @Column(name = "number")
    private Long number;

    @Column(name = "stock")
    private Long stock;

    //Quan hệ một - một của bảng sản phẩm với nhập kho
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id", referencedColumnName = "store_id")
    private Store store;

    //Quan hệ nhiều - một của bảng sản phẩm với loại sản phẩm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id")
    private Product_Category id_product;

    //Quan hệ một - nhiều của bảng sản phẩm với hóa đơn chi tiết
    @OneToMany(mappedBy = "id_pro")
    private List<BillDetail> listBillDetail;

    //Quan hệ nhiều - nhiều của bảng sản phẩm và người cung cấp
    @ManyToMany()
    @JoinTable(
            name="product_provider",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "provider_id")
    )
    private List<Provider> providers;

    public Product() {
    }

    public Product(Long product_id, String product_code, String product_name, Float sell_price, String unit, String description, Date date_created, String status, String product_img, Long number, Long stock) {
        this.product_id = product_id;
        this.product_code = product_code;
        this.product_name = product_name;
        this.sell_price = sell_price;
        this.unit = unit;
        this.description = description;
        this.date_created = date_created;
        this.status = status;
        this.product_img = product_img;
        this.number = number;
        this.stock = stock;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Float getSell_price() {
        return sell_price;
    }

    public void setSell_price(Float sell_price) {
        this.sell_price = sell_price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }
}
