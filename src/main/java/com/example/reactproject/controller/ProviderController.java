package com.example.reactproject.controller;

import com.example.reactproject.model.Provider;
import com.example.reactproject.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProviderController {
    @Autowired
    private ProviderRepository providerRepository;

    //get All
    @GetMapping("/provider")
    public List<Provider> getAllProvider(){
        return  providerRepository.findAll();
    }
}
