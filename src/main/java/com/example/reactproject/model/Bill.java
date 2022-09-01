package com.example.reactproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @Column(name = "bill_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bill_id;

    @Column(name = "bill_code")
    private  String bill_code;

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "mm/dd/yy")
    private Date date_created;

    @Column(name = "total_price")
    private float total_price;

    @Column(name = "discount")
    private String discount;

    @Column(name = "method_payment")
    private String method_payment;

    //Quan hệ một - một của bảng hóa đơn với nhân viên
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    //Quan hệ một - một của bảng hóa đơn với khách hàng
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    public Bill() {
    }

    public Bill(Long bill_id, String bill_code, Date date_created, float total_price, String discount, String method_payment, Employee employee, Customer customer) {
        this.bill_id = bill_id;
        this.bill_code = bill_code;
        this.date_created = date_created;
        this.total_price = total_price;
        this.discount = discount;
        this.method_payment = method_payment;
        this.employee = employee;
        this.customer = customer;
    }

    public Long getBill_id() {
        return bill_id;
    }

    public void setBill_id(Long bill_id) {
        this.bill_id = bill_id;
    }

    public String getBill_code() {
        return bill_code;
    }

    public void setBill_code(String bill_code) {
        this.bill_code = bill_code;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getMethod_payment() {
        return method_payment;
    }

    public void setMethod_payment(String method_payment) {
        this.method_payment = method_payment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
