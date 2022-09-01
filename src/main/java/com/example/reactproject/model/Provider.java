package com.example.reactproject.model;

import javax.persistence.*;

@Entity
@Table(name = "provider")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "provider_id", nullable = false)
    private Long provider_id;

    @Column(name = "provider_name")
    private String provider_name;

    @Column(name = "provider_address")
    private String provider_address;

    @Column(name = "provider_phone")
    private String provider_phone;

    @Column(name = "website")
    private String website;

    public Provider() {
    }

    public Provider(Long provider_id, String provider_name, String provider_address, String provider_phone, String website) {
        this.provider_id = provider_id;
        this.provider_name = provider_name;
        this.provider_address = provider_address;
        this.provider_phone = provider_phone;
        this.website = website;
    }

    public Long getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(Long provider_id) {
        this.provider_id = provider_id;
    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getProvider_address() {
        return provider_address;
    }

    public void setProvider_address(String provider_address) {
        this.provider_address = provider_address;
    }

    public String getProvider_phone() {
        return provider_phone;
    }

    public void setProvider_phone(String provider_phone) {
        this.provider_phone = provider_phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString(){
        return this.provider_name;
    }
}
