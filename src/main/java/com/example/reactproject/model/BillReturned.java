package com.example.reactproject.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bill_returned")
public class BillReturned {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_return_id", nullable = false)
    private Long bill_return_id;

    @Column(name = "reason_returned")
    private String reason_returned;

    @Column(name = "date_returned")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "mm/dd/yy")
    private Date date_returned;

    public BillReturned() {
    }

    public BillReturned(Long bill_return_id, String reason_returned, Date date_returned, Bill bill) {
        this.bill_return_id = bill_return_id;
        this.reason_returned = reason_returned;
        this.date_returned = date_returned;
        this.bill = bill;
    }

    //Quan hệ một - một của bảng hóa đơn và hóa đơn trả hàng
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_id", referencedColumnName = "bill_id")
    private Bill bill;

    public Long getBill_return_id() {
        return bill_return_id;
    }

    public void setBill_return_id(Long bill_return_id) {
        this.bill_return_id = bill_return_id;
    }

    public String getReason_returned() {
        return reason_returned;
    }

    public void setReason_returned(String reason_returned) {
        this.reason_returned = reason_returned;
    }

    public Date getDate_returned() {
        return date_returned;
    }

    public void setDate_returned(Date date_returned) {
        this.date_returned = date_returned;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
