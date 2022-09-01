package com.example.reactproject.model;

import javax.persistence.*;

@Entity
@Table(name = "bill_detail")
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_detail_id", nullable = false)
    private Long bill_detail_id;

    @Column(name = "number")
    private Long number;

    @Column(name = "price")
    private Float price;

    public BillDetail() {
    }

    public BillDetail(Long bill_detail_id, Long number, Float price, Bill bill, Product id_pro) {
        this.bill_detail_id = bill_detail_id;
        this.number = number;
        this.price = price;
        this.bill = bill;
        this.id_pro = id_pro;
    }

    // Quan hệ một - một của bảng hóa đơn và hóa đơn chi tiết
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
    private Bill bill;

    //Quan hệ nhiều - một của bảng hóa đơn chi tiết và sản phẩm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product id_pro;


    public Long getBill_detail_id() {
        return bill_detail_id;
    }

    public void setBill_detail_id(Long bill_detail_id) {
        this.bill_detail_id = bill_detail_id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Product getId_pro() {
        return id_pro;
    }

    public void setId_pro(Product id_pro) {
        this.id_pro = id_pro;
    }
}
